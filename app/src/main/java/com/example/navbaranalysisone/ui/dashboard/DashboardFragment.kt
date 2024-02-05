package com.example.navbaranalysisone.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navbaranalysisone.LoginActivity
import com.example.navbaranalysisone.R
import com.example.navbaranalysisone.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    //
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val categoryTextView: TextView = binding.categoryTextView
        val jokeTextView: TextView = binding.jokeTextView
        val setupTextView: TextView = binding.setupTextView
        val deliveryTextView: TextView = binding.deliveryTextView

        dashboardViewModel.text.observe(viewLifecycleOwner) { list ->
            // Handle the list of items (EndPtTwoModelItem) here
            val item = list.firstOrNull()
            categoryTextView.text = "${item?.category}"
            jokeTextView.text = "${item?.joke}"
            setupTextView.text = "${item?.setup}"
            deliveryTextView.text = "${item?.delivery}"
        }

        // Trigger the API call when the fragment is created
        dashboardViewModel.getText()

        val signOutButton: Button = binding.root.findViewById(R.id.signOutButton)
        signOutButton.setOnClickListener {
            signOut()
        }

        return root
    }

    private fun signOut() {
        FirebaseAuth.getInstance().signOut()

        // Navigate back to the login activity
        val intent = Intent(activity, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish() // Optional: Close the current activity if needed
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
