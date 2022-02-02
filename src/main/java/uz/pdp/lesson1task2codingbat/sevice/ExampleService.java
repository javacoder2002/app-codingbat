package uz.pdp.lesson1task2codingbat.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.lesson1task2codingbat.entity.Example;
import uz.pdp.lesson1task2codingbat.entity.Task;
import uz.pdp.lesson1task2codingbat.payload.ApiResponse;
import uz.pdp.lesson1task2codingbat.payload.ExampleDto;
import uz.pdp.lesson1task2codingbat.repository.ExampleRepository;
import uz.pdp.lesson1task2codingbat.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExampleService {

    @Autowired
    ExampleRepository exampleRepository;

    @Autowired
    TaskRepository taskRepository;

    /**
     * This method returns all examples
     * @return Examples
     */
    public List<Example> getExamples() {
        return exampleRepository.findAll();
    }

    /**
     * This method returns one example by id.
     * @param id
     * @return Example
     */
    public Example getExample(Integer id) {
        Optional<Example> optionalExample = exampleRepository.findById(id);
        return optionalExample.orElse(null);
    }

    /**
     * This method saves a new example.
     * @param exampleDto
     * @return ApiResponse
     */
    public ApiResponse addExample(ExampleDto exampleDto) {
        Optional<Task> optionalTask = taskRepository.findById(exampleDto.getTaskId());
        if (optionalTask.isEmpty())
            return new ApiResponse(false, "task not found!");

        Example example = new Example();
        example.setRequest(exampleDto.getRequest());
        example.setResponse(exampleDto.getResponse());
        example.setTask(optionalTask.get());
        exampleRepository.save(example);
        return new ApiResponse(true, "example saved!");
    }

    /**
     * This method edits example.(by id)
     * @param id
     * @param exampleDto
     * @return ApiResponse
     */
    public ApiResponse editeExample(Integer id, ExampleDto exampleDto) {

        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (optionalExample.isEmpty())
            return new ApiResponse(false, "example not found!");

        Optional<Task> optionalTask = taskRepository.findById(exampleDto.getTaskId());
        if (optionalTask.isEmpty())
            return new ApiResponse(false, "task not found!");

        Example example = optionalExample.get();
        example.setRequest(exampleDto.getRequest());
        example.setResponse(exampleDto.getResponse());
        example.setTask(optionalTask.get());
        exampleRepository.save(example);
        return new ApiResponse(true, "example edited!");

    }

    /**
     * This method deletes example by id.
     * @param id
     * @return ApiResponse
     */
    public ApiResponse deleteExample(Integer id) {
        Optional<Example> optionalExample = exampleRepository.findById(id);
        if (optionalExample.isEmpty())
            return new ApiResponse(false, "example not found!");
        exampleRepository.deleteById(id);
        return new ApiResponse(true, "example deleted!");
    }
}








