package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTests {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {
        taskerDao.getAllTasks().stream().forEach(t -> taskerDao.deleteTask(t.getId()));
    }

    @Test
    public void createGetGetAllGetByCatDeleteTask() {
        Task task = new Task();
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019, 8, 2));
        task.setDueDate(LocalDate.of(2019,7,30));
        task.setCategory("Category");

        taskerDao.createTask(task);

        assertEquals(taskerDao.getTask(task.getId()), task);

        assertEquals(taskerDao.getAllTasks().size(), 1);

        assertEquals(taskerDao.getTasksByCategory("Category").size(), 1);

        taskerDao.deleteTask(task.getId());

        assertNull(taskerDao.getTask(task.getId()));
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019,2,2));
        task.setDueDate(LocalDate.of(2019, 2,2));
        task.setCategory("category your mother");

        taskerDao.createTask(task);

        task.setDescription("Update Description");
        task.setCreateDate(LocalDate.of(2018,2,2));
        task.setDueDate(LocalDate.of(2018, 2,2));
        task.setCategory("update category your mother");


        taskerDao.updateTask(task);

        assertEquals(taskerDao.getTask(task.getId()), task);

    }
}
