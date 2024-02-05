package com.example.navbaranalysisone.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navbaranalysisone.LoginActivity
import com.example.navbaranalysisone.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val titleTextView: TextView = binding.titleTextView
        val authorTextView: TextView = binding.authorTextView
        val linesTextView: TextView = binding.linesTextView

        homeViewModel.text.observe(viewLifecycleOwner) { list ->
            // Handle the list of items (EndPtOneModelItem) here
            val item = list.firstOrNull() // Assuming you want to display the first item
            titleTextView.text = "${item?.title}"
            authorTextView.text = "${item?.author}"
            linesTextView.text = "${item?.lines?.joinToString()}"
        }

        // Trigger the API call when the fragment is created
        homeViewModel.getText()

//        val signOutButton: Button = binding.root.findViewById(R.id.signOutButton)
//        signOutButton.setOnClickListener {
//            signOut()
//        }

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
