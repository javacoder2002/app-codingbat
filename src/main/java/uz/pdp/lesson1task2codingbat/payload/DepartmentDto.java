package uz.pdp.lesson1task2codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @NotNull(message = "name should not be empty")
    private String name;

    @NotNull(message = "shortInfo should not be empty")
    private String shortInfo;

    @NotNull(message = "starCount should not be empty")
    private Integer starCount;

    @NotNull(message = "programmingLanguageId should not be empty")
    private Integer programmingLanguageId;

}
