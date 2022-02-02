package uz.pdp.lesson1task2codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lesson1task2codingbat.entity.Done;

@Repository
public interface DoneRepository extends JpaRepository<Done,Integer> {

    boolean existsByUserIdAndTaskId(Integer user_id, Integer task_id);

}
