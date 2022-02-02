package uz.pdp.lesson1task2codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lesson1task2codingbat.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    boolean existsByNameAndDepartmentId(String name, Integer department_id);

    boolean existsByNameAndDepartmentIdAndIdNot(String name, Integer department_id, Integer id);

}
