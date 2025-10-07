package com.bezy_dev.tasks.services.impl;

import com.bezy_dev.tasks.domain.entities.Task;
import com.bezy_dev.tasks.domain.entities.TaskList;
import com.bezy_dev.tasks.domain.entities.TaskPriority;
import com.bezy_dev.tasks.domain.entities.TaskStatus;
import com.bezy_dev.tasks.repositories.TaskListRepository;
import com.bezy_dev.tasks.repositories.TaskRepository;
import com.bezy_dev.tasks.services.TaskService;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private TaskListRepository taskListRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(UUID taskListId, Task task) {
        if(null != task.getId()){
            throw new IllegalArgumentException("Task list already has an ID!");
        }
        if(null == task.getTitle() || task.getTitle().isBlank()){
            throw new IllegalArgumentException("Task list title must be present!");
        }

        TaskPriority taskPriority = Optional.ofNullable(task.getPriority())
                .orElse(TaskPriority.MEDIUM);

        TaskStatus taskStatus = TaskStatus.OPEN;

        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task List Id Provided!"));

        LocalDateTime now = LocalDateTime.now();
        Task taskToSave = new Task(
                null,
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                taskStatus,
                taskPriority,
                taskList,
                now,
                now
        );

        return taskRepository.save(taskToSave);
    }

    @Override
    public Optional<Task> getTask(UUID taskListId, UUID taskId) {
        return taskRepository.findByTaskListIdAndId(taskListId, taskId);
    }

    @Override
    public Task updateTask(UUID taskListId, UUID taskId, Task task) {
         if(null == task.getId()){
             throw new IllegalArgumentException("Task list has no ID Provided!");
         }
         if(Objects.equals(taskId, task.getId())){
             throw new IllegalArgumentException("Task list has no ID Provided!");
         }
         if(null == task.getTitle() || task.getTitle().isBlank()){
             throw new IllegalArgumentException("Task must have a valid priority!");
         }
         if(null == task.getStatus()){
             throw new IllegalArgumentException("Task must have a valid status!");
         }

         Task existingTask = taskRepository.findByTaskListIdAndId(taskListId, taskId)
                 .orElseThrow(() -> new IllegalArgumentException("Invalid Task Id Provided!"));

         existingTask.setTitle(task.getTitle());
         existingTask.setDescription(task.getDescription());
         existingTask.setDueDate(task.getDueDate());
         existingTask.setPriority(task.getPriority());
         existingTask.setStatus(task.getStatus());
         existingTask.setUpdated(LocalDateTime.now());

         return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(UUID taskListId, UUID taskId) {
        taskRepository.deleteById(taskId);
    }
}
