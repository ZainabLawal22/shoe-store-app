package com.example.shoestoreappudacitynanodegree.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shoestoreappudacitynanodegree.R
import com.example.shoestoreappudacitynanodegree.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.buttonLogIn.setOnClickListener {
            existingUser()
        }
        binding.buttonSignUp.setOnClickListener {
            signUpNewUser()
        }
    }

    private fun existingUser() {
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()
        if (viewModel.verifyCredentials(email, password)) {
            navigateToWelcomeScreen()
        } else {
            Toast.makeText(requireContext(), "Invalid login details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signUpNewUser() {
        val email = binding.editTextEmail.text.toString()
        val password = binding.editTextPassword.text.toString()
        if (viewModel.isUserAlreadyExisting(email)) {
            Toast.makeText(requireContext(), "User already exists", Toast.LENGTH_SHORT).show()
        } else if (viewModel.addCredentials(email, password)) {
            Toast.makeText(requireContext(), "Registration successful", Toast.LENGTH_SHORT).show()
            navigateToWelcomeScreen()
        } else {
            Toast.makeText(requireContext(), "Please enter valid details", Toast.LENGTH_SHORT).show()
        }
    }
    private fun navigateToWelcomeScreen() {
        //todo uncomment later when the gradle sync successful
        findNavController().navigate(R.id.welcomeFragment)
//        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
//        findNavController().navigate(action)
        Toast.makeText(requireContext(), "This button was clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
