package com.example.finalproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.viewmodels.LoginViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_main)

        (application as FinalApplication).appComponent.inject(this)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_menu_nav)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment!!.navController
        )

        fun showBottomNav() {
            bottomNavigationView.visibility = View.VISIBLE
        }

        fun hideBottomNav() {
            bottomNavigationView.visibility = View.GONE
        }

        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragment_search -> showBottomNav()
                R.id.fragment_created_challenges -> showBottomNav()
                R.id.fragment_taken_challenges -> showBottomNav()
                R.id.fragment_profile -> showBottomNav()
                else -> hideBottomNav()
            }
        }


    }
}