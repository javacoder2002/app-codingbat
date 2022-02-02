package uz.pdp.lesson1task2codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.lesson1task2codingbat.entity.Task;
import uz.pdp.lesson1task2codingbat.payload.ApiResponse;
import uz.pdp.lesson1task2codingbat.payload.TaskDto;
import uz.pdp.lesson1task2codingbat.sevice.TaskService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    /**
     * This method returns list of tasks.
     * @return Tasks
     */
    @GetMapping
    public HttpEntity<List<Task>> getTasks(){
        List<Task> tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }

    /**
     * This method returns one task by id.
     * @param id
     * @return Task
     */
    @GetMapping("/{id}")
    public HttpEntity<Task> getTaskById(@PathVariable Integer id){
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    /**
     * This method adds new test.
     * @param taskDto
     * @return ApiResponse
     */
    @PostMapping
    public HttpEntity<ApiResponse> addTask(@Valid @RequestBody TaskDto taskDto){
        ApiResponse apiResponse = taskService.addTask(taskDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    /**
     * This method edits task by id.
     * @param id
     * @param taskDto
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public HttpEntity<ApiResponse> editeTask(@PathVariable Integer id, @Valid @RequestBody TaskDto taskDto){
        ApiResponse apiResponse = taskService.editeTask(id, taskDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }

    /**
     * This method deletes task by id.
     * @param id
     * @return ApiResponse
     */
    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponse> deleteTask(@PathVariable Integer id){
        ApiResponse apiResponse = taskService.deleteTask(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 202 : 409).body(apiResponse);
    }

}



















