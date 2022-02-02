package uz.pdp.lesson1task2codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lesson1task2codingbat.entity.Example;

@Repository
public interface ExampleRepository extends JpaRepository<Example,Integer> {

}
