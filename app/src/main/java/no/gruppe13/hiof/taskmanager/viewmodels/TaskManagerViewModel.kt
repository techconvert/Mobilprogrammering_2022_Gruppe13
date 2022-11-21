package no.gruppe13.hiof.taskmanager.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import no.gruppe13.hiof.taskmanager.data.Task
import no.gruppe13.hiof.taskmanager.data.category.CategoryDao
import no.gruppe13.hiof.taskmanager.data.TaskDao
import no.gruppe13.hiof.taskmanager.data.category.Category

class TaskManagerViewModel(private val taskDao: TaskDao, private val categoryDao: CategoryDao): ViewModel() {
    fun allTasks(): Flow<List<Task>> = taskDao.getAllTasks()
    fun allCategories(): Flow<List<Category>> = categoryDao.getAll()
    fun getCategory(categoryId: Int) = categoryDao.getCategory(categoryId)
}