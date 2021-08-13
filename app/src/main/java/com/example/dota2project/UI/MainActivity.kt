package com.example.dota2project.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.dota2project.R
import com.example.dota2project.ViewModel.DotaViewModel
import com.example.dota2project.ViewModel.DotaViewModelFactory
import com.example.dota2project.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var viewModel: DotaViewModel
    private lateinit var binding: ActivityMainBinding


    @Inject
    lateinit var factory: DotaViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)



        setContentView(binding.root)

        FirebaseApp.initializeApp(this)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        val navController = navHostFragment.navController

        setSupportActionBar(toolbar)

        toolbar.setupWithNavController(navController, drawer_layout)
        nav_view.setupWithNavController(navController)

        viewModel = ViewModelProvider(this, factory).get(DotaViewModel :: class.java)

    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.top_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        if(item.itemId.equals(R.id.heroesList)){
            navController.navigate(R.id.heroesList)
        }else {
            navController.navigate(R.id.heroesList)
        }

        return super.onOptionsItemSelected(item)
    }




}