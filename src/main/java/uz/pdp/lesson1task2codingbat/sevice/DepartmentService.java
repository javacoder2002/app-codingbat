package uz.pdp.lesson1task2codingbat.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson1task2codingbat.entity.Department;
import uz.pdp.lesson1task2codingbat.entity.ProgrammingLanguage;
import uz.pdp.lesson1task2codingbat.payload.ApiResponse;
import uz.pdp.lesson1task2codingbat.payload.DepartmentDto;
import uz.pdp.lesson1task2codingbat.repository.DepartmentRepository;
import uz.pdp.lesson1task2codingbat.repository.ProgrammingLanguageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ProgrammingLanguageRepository programmingLanguageRepository;

    /**
     * This method returns all departments.
     * @return departments
     */
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * This method returns one department by id.
     * @param id
     * @return department
     */
    public Department getDepartmentById(Integer id) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        return optionalDepartment.orElse(null);
    }

    /**
     * This method saves a new department.
     * @param departmentDto
     * @return ApiResponse
     */
    public ApiResponse addDepartment(DepartmentDto departmentDto) {

        boolean exist = departmentRepository.existsByNameAndProgrammingLanguageId(
                departmentDto.getName(),
                departmentDto.getProgrammingLanguageId());

        if (exist)
            return new ApiResponse(false, "this department already exist!");

        Optional<ProgrammingLanguage> optionalProgrammingLanguage = programmingLanguageRepository
                .findById(departmentDto.getProgrammingLanguageId());
        if (optionalProgrammingLanguage.isEmpty())
            return new ApiResponse(false, "Programming language not found!");

        Department department = new Department();
        department.setName(departmentDto.getName());
        department.setStarCount(departmentDto.getStarCount());
        department.setShortInfo(departmentDto.getShortInfo());
        department.setProgrammingLanguage(optionalProgrammingLanguage.get());

        departmentRepository.save(department);
        return new ApiResponse(true, "department saved!");

    }


}














