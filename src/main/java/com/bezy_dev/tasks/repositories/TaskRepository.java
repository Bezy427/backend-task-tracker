package com.bezy_dev.tasks.repositories;

import com.bezy_dev.tasks.domain.entities.Task;
import com.bezy_dev.tasks.domain.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByTaskListId(UUID taskList);
    Optional<Task> findByTaskListIdAndId(UUID taskList, UUID id);
    void deleteByTaskListIdAndId(UUID taskList, UUID id);
}
