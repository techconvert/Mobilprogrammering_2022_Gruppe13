package no.gruppe13.hiof.taskmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Database
import kotlinx.coroutines.launch
import no.gruppe13.hiof.taskmanager.data.TaskDatabase
import no.gruppe13.hiof.taskmanager.data.category.Category
import no.gruppe13.hiof.taskmanager.data.category.CategoryDao
import no.gruppe13.hiof.taskmanager.data.category.CategoryDao_Impl
import no.gruppe13.hiof.taskmanager.databinding.ActivityCreateCategoryBinding
import no.gruppe13.hiof.taskmanager.databinding.ActivityCreateTaskBinding

class CreateCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createCategoryButton.setOnClickListener {
            val context = binding.createCategoryButton.context
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)

            val category = Category(
                0, binding.categoryInput.text.toString(), binding.commentInput.text.toString()
            )

            val db = TaskDatabase.getDatabase(this)
            lifecycleScope.launch{
                db.categoryDao().insertCategory(category)
            }

            val toast = Toast.makeText(this, "Kategori opprettet!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}