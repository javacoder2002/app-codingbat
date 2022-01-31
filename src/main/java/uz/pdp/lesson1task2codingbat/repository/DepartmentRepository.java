package uz.pdp.lesson1task2codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lesson1task2codingbat.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    boolean existsByNameAndProgrammingLanguageId(String name, Integer programmingLanguage_id);

    boolean existsByNameAndProgrammingLanguageIdAndIdNot(String name, Integer programmingLanguage_id, Integer id);

}
