package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TaskerServiceLayerTests {
    TaskerDao taskerDao;
    AdServiceClient adServiceClient;
    TaskerServiceLayer service;

    @Before
    public void setUp() throws Exception {

        setUpTaskerDaoMock();
        setUpAdServiceClientMock();

        service = new TaskerServiceLayer(taskerDao, adServiceClient);
    }

    public void setUpTaskerDaoMock() {
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(1);
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019,8,1));
        task.setDueDate(LocalDate.of(2019,8,1));
        task.setCategory("Category");

        Task task1 = new Task();
        task1.setDescription("Description");
        task1.setCreateDate(LocalDate.of(2019,8,1));
        task1.setDueDate(LocalDate.of(2019,8,1));
        task1.setCategory("Category");

        List<Task> tList = new ArrayList<>();
        tList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(tList).when(taskerDao).getAllTasks();
        doReturn(tList).when(taskerDao).getTasksByCategory("Category");
        doReturn(task).when(taskerDao).getTask(1);
    }

    public void setUpAdServiceClientMock() {
        adServiceClient = mock(AdServiceClient.class);

        doReturn("Ad").when(adServiceClient).getAd();
    }

    @Test
    public void saveFindFindAllFindByCategoryTasks() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription("Description");
        tvm.setCreateDate(LocalDate.of(2019, 8, 1));
        tvm.setDueDate(LocalDate.of(2019,8,1));
        tvm.setCategory("Category");

        tvm = service.saveTask(tvm);
        TaskViewModel fromService = service.fetchTask(1);

        assertEquals(tvm, fromService);
        List<TaskViewModel> fromServiceList = service.fetchTasksByCategory("Category");
        assertEquals(fromServiceList.size(), 1);

        assertEquals(service.fetchAllTasks().size(), 1);
    }

    @Test
    public void updateTask() {
        TaskViewModel tvm = service.fetchTask(1);

        tvm.setDescription("Updated Description");
        tvm.setCreateDate(LocalDate.of(2019,8,2));
        tvm.setDueDate(LocalDate.of(2019,8,2));
        tvm.setCategory("Updated Category");


        service.updateTask(tvm);

        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskerDao).updateTask(taskCaptor.capture());
        assertEquals(tvm.getDescription(), taskCaptor.getValue().getDescription());
    }

    @Test
    public void deleteTask() {
        TaskViewModel tvm = service.fetchTask(1);
        service.deleteTask(1);
        ArgumentCaptor<Integer> taskCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(taskerDao).deleteTask(taskCaptor.capture());
        assertEquals(tvm.getId(), taskCaptor.getValue().intValue());
    }
}
