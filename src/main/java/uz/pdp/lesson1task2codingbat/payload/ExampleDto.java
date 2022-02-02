package uz.pdp.lesson1task2codingbat.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleDto {

    @NotNull(message = "request shouldn't be empty.")
    private String request;

    @NotNull(message = "response shouldn't be empty.")
    private String response;

    @NotNull(message = "taskId shouldn't be empty.")
    private Integer taskId;

}
