package com.example.navbaranalysisone.ui.notifications

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
import com.example.navbaranalysisone.databinding.FragmentNotificationsBinding
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val authorTextView: TextView = binding.authorTextView
        val contentTextView: TextView = binding.contentTextView
        val tagsTextView: TextView = binding.tagsTextView

        notificationsViewModel.text.observe(viewLifecycleOwner) { item ->
            // Handle the single item (EndPtThreeModelItem) here
            authorTextView.text = "${item?.author.orEmpty()}"
            contentTextView.text = "${item?.content.orEmpty()}"
            tagsTextView.text = "${item?.tags?.joinToString().orEmpty()}"
        }

        // Trigger the API call when the fragment is created
        notificationsViewModel.getText()

        // Add sign-out button click listener
        val signOutButton: Button = binding.root.findViewById(R.id.signOutButton)
        signOutButton.setOnClickListener {
            signOut()
        }


        return root
    }

    fun signOut() {
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
