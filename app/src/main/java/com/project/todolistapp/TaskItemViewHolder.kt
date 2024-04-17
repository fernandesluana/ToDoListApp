package com.project.todolistapp

import android.content.Context
import android.graphics.Paint
import android.opengl.Visibility
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.project.todolistapp.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(
    private val context: Context,
    private val binding : TaskItemCellBinding,
    private val clickListener: TaskItemClickListener

    ): RecyclerView.ViewHolder(binding.root) {


        val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

        fun bindTaskItem(taskItem: TaskItem){
            binding.name.text = taskItem.name

            if(taskItem.isCompleted()){
                binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }

            binding.completeBtn.setImageResource(taskItem.imageResource())
            binding.completeBtn.setColorFilter(taskItem.imageColor(context))

            binding.completeBtn.setOnClickListener{
                clickListener.completeTaskItem(taskItem)
            }

            binding.taskCellContainer.setOnClickListener{
                clickListener.editTaskItem(taskItem)
            }


            if(taskItem.dueTime != null) {
                binding.dueTime.text = timeFormat.format(taskItem.dueTime)
            } else {
                binding.dueTime.text = ""
            }
        }
}