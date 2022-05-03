package com.example.techtest.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.techtest.R
import com.example.techtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityBinding: ActivityMainBinding
    private var backToExitPressedOnce: Boolean = false
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        init()

    }

//    initialize navigation host fragment
    private fun init(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navController = navHostFragment.navController
    }

//    take control over fragments while device back button pressed state
    override fun onBackPressed() {
        val fragmentId = Navigation.findNavController(this, R.id.nav_host_fragment_container).currentDestination!!.id
        if( fragmentId == R.id.homeFragment){
            exitApp()
            return
        }else {
            val navFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
            val entryCount = navFragment!!.childFragmentManager.backStackEntryCount
            println("Back stack : $entryCount")
            if(entryCount>0){
                navController.navigateUp()
            }else{
                super.onBackPressed()
            }

        }
    }

//    check whether the back button pressed twice to exit application
    private fun exitApp() {
        if (!backToExitPressedOnce) {
            backToExitPressedOnce = true
            Toast.makeText(this, "Press BACK again to Exit.", Toast.LENGTH_SHORT).show()
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    backToExitPressedOnce = false
                }, 2000
            )
        } else {
            this.finishAffinity()
        }
    }
}