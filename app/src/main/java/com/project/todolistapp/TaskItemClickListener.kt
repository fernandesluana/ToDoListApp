package com.project.todolistapp

interface TaskItemClickListener
{

    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)

}