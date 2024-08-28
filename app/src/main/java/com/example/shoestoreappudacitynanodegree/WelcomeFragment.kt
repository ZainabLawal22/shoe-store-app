package com.example.shoestoreappudacitynanodegree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.shoestoreappudacitynanodegree.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.instructionFragment)
        }
        return binding.root
        // return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}