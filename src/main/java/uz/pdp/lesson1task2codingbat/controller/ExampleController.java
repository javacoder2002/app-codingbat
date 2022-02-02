package uz.pdp.lesson1task2codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson1task2codingbat.entity.Example;
import uz.pdp.lesson1task2codingbat.payload.ApiResponse;
import uz.pdp.lesson1task2codingbat.payload.ExampleDto;
import uz.pdp.lesson1task2codingbat.sevice.ExampleService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/example")
public class ExampleController {

    @Autowired
    ExampleService exampleService;

    /**
     * This method returns all examples
     * @return Examples
     */
    @GetMapping
    public HttpEntity<List<Example>> getExamples(){
        List<Example> examples = exampleService.getExamples();
        return ResponseEntity.ok(examples);
    }

    /**
     * This method returns one example by id.
     * @param id
     * @return Example
     */
    @GetMapping("/{id}")
    public HttpEntity<Example> getExample(@PathVariable Integer id){
        Example example = exampleService.getExample(id);
        return ResponseEntity.ok(example);
    }

    /**
     * This method saves a new example.
     * @param exampleDto
     * @return ApiResponse
     */
    @PostMapping
    public HttpEntity<ApiResponse> addExample(@Valid @RequestBody ExampleDto exampleDto){
        ApiResponse apiResponse = exampleService.addExample(exampleDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    /**
     * This method edits example.(by id)
     * @param id
     * @param exampleDto
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public HttpEntity<ApiResponse> editeExample(@PathVariable Integer id,
                                                @Valid @RequestBody ExampleDto exampleDto){
        ApiResponse apiResponse = exampleService.editeExample(id, exampleDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }

    /**
     * This method deletes example by id.
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponse> deleteExample(@PathVariable Integer id){
        ApiResponse apiResponse = exampleService.deleteExample(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }



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
