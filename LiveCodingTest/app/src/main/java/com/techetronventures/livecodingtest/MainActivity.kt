package com.techetronventures.livecodingtest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_item_home -> {
                    if (navController.currentDestination?.id != R.id.homeFragment) {
                        navController.popBackStack()
                        navController.navigate(R.id.homeFragment)
                    }
                    true
                }
                R.id.menu_item_details -> {
                    if (navController.currentDestination?.id != R.id.detailsFragment) {
                        navController.popBackStack()
                        navController.navigate(R.id.detailsFragment)
                    }
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}