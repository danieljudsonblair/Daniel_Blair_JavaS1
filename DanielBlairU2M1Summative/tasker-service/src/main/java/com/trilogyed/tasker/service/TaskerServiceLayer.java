package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    TaskerDao dao;
    AdServiceClient client;

    @Autowired
    TaskerServiceLayer(TaskerDao dao, AdServiceClient client) {
        this.dao = dao;
        this.client = client;
    }

    @Transactional
    public TaskViewModel saveTask(TaskViewModel tvm) {
        Task task = new Task();
        task.setDescription(tvm.getDescription());
        task.setCreateDate(tvm.getCreateDate());
        task.setDueDate(tvm.getDueDate());
        task.setCategory(tvm.getCategory());

        tvm.setId(dao.createTask(task).getId());
        tvm.setAdvertisement(client.getAd());

        return tvm;
    }

    public TaskViewModel fetchTask(int id) {
        Task task = dao.getTask(id);
        if (task == null)
            throw new NotFoundException("No task exists @ ID " + id);
        return buildNewTaskHelper(task);
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<TaskViewModel> tvmList = new ArrayList<>();
        dao.getAllTasks().stream().forEach(task -> tvmList.add(buildNewTaskHelper(task)));

        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<TaskViewModel> tvmList = new ArrayList<>();
        dao.getTasksByCategory(category).stream().forEach(task -> tvmList.add(buildNewTaskHelper(task)));

        return tvmList;
    }

    public void updateTask(TaskViewModel tvm) {
        Task ut = dao.getTask(tvm.getId());

        if (ut == null)
            throw new NotFoundException("No task found @ ID " + tvm.getId());
        if (tvm.getDescription() != null && tvm.getDescription().equals(""))
            throw new IllegalArgumentException("description must not be empty");
        if (tvm.getDescription() != null)
            ut.setDescription(tvm.getDescription());
        if (tvm.getCreateDate() != null && tvm.getCreateDate().equals(""))
            throw new IllegalArgumentException("create date must not be empty");
        if (tvm.getCreateDate() != null)
            ut.setCreateDate(tvm.getCreateDate());
        if (tvm.getDueDate() != null && tvm.getDueDate().equals(""))
            throw new IllegalArgumentException("due date must not be empty");
        if (tvm.getDueDate() != null)
            ut.setDueDate(tvm.getDueDate());
        if (tvm.getCategory() != null && tvm.getCategory().equals(""))
            throw new IllegalArgumentException("category must not be empty");
        if (tvm.getCategory() != null)
            ut.setCategory(tvm.getCategory());

        dao.updateTask(ut);
    }

    public void deleteTask(int id) {
        if (dao.getTask(id) == null)
            throw new NotFoundException("No task found @ ID " + id);
        dao.deleteTask(id);
    }

    private TaskViewModel buildNewTaskHelper(Task task) {

        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(client.getAd());

        return tvm;
    }


}
