package no.gruppe13.hiof.taskmanager

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.activityViewModels

import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import no.gruppe13.hiof.taskmanager.databinding.ActivityMainBinding
import no.gruppe13.hiof.taskmanager.viewmodels.TaskManagerViewModel
import no.gruppe13.hiof.taskmanager.viewmodels.TaskManagerViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
/*
        val navController = findNavController(R.id.nav_view)
        NavigationUI.setupActionBarWithNavController(navController, appBarConfiguration)*/
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }
}