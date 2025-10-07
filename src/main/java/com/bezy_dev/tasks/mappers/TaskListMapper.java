package com.bezy_dev.tasks.mappers;

import com.bezy_dev.tasks.domain.dtos.TaskListDto;
import com.bezy_dev.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
