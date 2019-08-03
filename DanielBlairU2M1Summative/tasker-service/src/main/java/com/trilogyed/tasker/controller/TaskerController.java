package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/tasks")

public class TaskerController {

    @Autowired
    TaskerServiceLayer service;


    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel tvm) {
        return service.saveTask(tvm);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable int id) {
        TaskViewModel tvm = service.fetchTask(id);
        if (tvm == null)
            throw new NotFoundException("Task could not be retrieved for id " + id);
        return tvm;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks() {
        return service.fetchAllTasks();
    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(@PathVariable String category) {
        return service.fetchTasksByCategory(category);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable int id, @RequestBody TaskViewModel tvm) {
        if (tvm.getId() == 0)
            tvm.setId(id);
        if (id != tvm.getId())
            throw new IllegalArgumentException("No task object found to update @ ID " + id);

        service.updateTask(tvm);
    }

    @RequestMapping(value = "/tasks{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}
