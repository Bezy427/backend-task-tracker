package com.bezy_dev.tasks.mappers;

import com.bezy_dev.tasks.domain.dtos.TaskDto;
import com.bezy_dev.tasks.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);

}
