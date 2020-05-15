package com.seno.bukawarungtest.view

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.seno.bukawarungtest.R
import com.seno.bukawarungtest.dagger.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.navHost)
        navController.setGraph(R.navigation.nav_main)

        setupActionBarWithNavController(navController)
        toolbar.setupWithNavController(navController)
        bottomNav.setupWithNavController(navController)

    }

}
