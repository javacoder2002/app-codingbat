package uz.pdp.lesson1task2codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    @NotNull(message = "name should not be empty!")
    private String name;

    @NotNull(message = "text should not be empty!")
    private String text;

    @NotNull(message = "answerBody should not be empty!")
    private String answerBody;

    @NotNull(message = "departmentId should not be empty!")
    private Integer departmentId;
}
