package uz.pdp.lesson1task2codingbat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.lesson1task2codingbat.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Integer id);

}
