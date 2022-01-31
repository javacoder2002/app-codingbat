package uz.pdp.lesson1task2codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson1task2codingbat.entity.Department;
import uz.pdp.lesson1task2codingbat.payload.ApiResponse;
import uz.pdp.lesson1task2codingbat.payload.DepartmentDto;
import uz.pdp.lesson1task2codingbat.sevice.DepartmentService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    /**
     * This method returns all departments.
     * @return departments
     */
    @GetMapping
    public HttpEntity<List<Department>> getDepartments(){
        List<Department> departments = departmentService.getDepartments();
        return ResponseEntity.ok(departments);
    }

    /**
     * This method returns one department by id.
     * @param id
     * @return department
     */
    @GetMapping("/{id}")
    public HttpEntity<Department> getDepartmentById(@PathVariable Integer id){
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    /**
     * This method saves a new department.
     * @param departmentDto
     * @return ApiResponse
     */
    @PostMapping
    public HttpEntity<ApiResponse> addDepartment(@Valid @RequestBody DepartmentDto departmentDto){
        ApiResponse apiResponse = departmentService.addDepartment(departmentDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    /*
    * need
    * */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
