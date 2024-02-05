package com.example.navbaranalysisone
/* The MainActivity.kt file in an Android application serves as the entry point and main controller for the activity. It's responsible for initializing the activity, setting up the user interface, and managing the navigation flow. */

// Importing the required libraries
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navbaranalysisone.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
// MainActivity class that extends AppCompatActivity
class MainActivity : AppCompatActivity() {
    // Binding object instance with access to the views in the activity_main.xml layout
    private lateinit var binding: ActivityMainBinding
    private lateinit var analytics: FirebaseAnalytics

    // Method called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        // Call the super class onCreate to complete the creation of activity like. Performs onCreate functions
        super.onCreate(savedInstanceState)
        // Inflate the activity_main.xml layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Initialize Firebase Analytics
        analytics = Firebase.analytics
        // Set the content view of the activity, which is specified by android:id="@+id/nav_host_fragment_activity_main" in the activity_main.xml layout file
        setContentView(binding.root)
        // Get the navigation host fragment from this Activity
        val navView: BottomNavigationView = binding.navView
        // Retrieving the NavController of the Activity using the findNavController() method
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            // Set of menu items that should be considered top level destinations.
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        // Setting up the ActionBar with the NavController
        setupActionBarWithNavController(navController, appBarConfiguration)
        // Setting up the BottomNavigationView with the NavController
        navView.setupWithNavController(navController)

        // Adding click listener for the sign-out button
        val signOutButton = findViewById<Button>(R.id.signOutButton)
        signOutButton.setOnClickListener {
            signOut()
        }

        logEvent()

    }

    fun logEvent() {
        analytics.logEvent(
            FirebaseAnalytics.Event.SELECT_CONTENT,
            bundleOf(
                FirebaseAnalytics.Param.ITEM_ID to "19",
                FirebaseAnalytics.Param.ITEM_NAME to "Aidan",
                FirebaseAnalytics.Param.CONTENT_TYPE to "text"

            )
        )
    }

    override fun onStart() {
        super.onStart()
        logEvent()
    }

    override fun onResume() {
        super.onResume()
        logEvent()
    }

    override fun onPause() {
        super.onPause()
        logEvent()
    }

    override fun onStop() {
        super.onStop()
        logEvent()
    }

    override fun onDestroy() {
        super.onDestroy()
        logEvent()
    }
    // Might not need this
    private fun signOut() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}