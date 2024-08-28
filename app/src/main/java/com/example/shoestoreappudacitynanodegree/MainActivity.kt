package com.example.shoestoreappudacitynanodegree

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.shoestoreappudacitynanodegree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding  : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
//        val navController = this.findNavController(R.id.nav_host_fragment_container)
//        NavigationUI.setupActionBarWithNavController(this, navController)

        // Initialize NavController using NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.shoeListFragment, R.id.loginFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

    }


    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.nav_host_fragment_container)
//        return navController.navigateUp()

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        return navController.navigateUp()
    }
}