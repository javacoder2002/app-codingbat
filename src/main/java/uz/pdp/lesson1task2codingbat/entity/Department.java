package uz.pdp.lesson1task2codingbat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "programmingLanguage"}))
public class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String shortInfo;

    @Column(nullable = false)
    private Integer starCount;

    @ManyToOne
    private ProgrammingLanguage programmingLanguage;

}
