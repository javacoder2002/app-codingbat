package uz.pdp.lesson1task2codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammingLanguageDto {

    @NotNull(message = "name should not be empty!")
    private String name;
    
}
