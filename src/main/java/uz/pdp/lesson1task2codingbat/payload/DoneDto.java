package uz.pdp.lesson1task2codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoneDto {

    @NotNull(message = "userId shouldn't be empty.")
    private Integer userId;

    @NotNull(message = "taskId shouldn't be empty.")
    private Integer taskId;

}
