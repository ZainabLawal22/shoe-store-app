package com.example.shoestoreappudacitynanodegree

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shoestoreappudacitynanodegree.databinding.FragmentInstructionBinding



class InstructionFragment : Fragment() {
    private var _binding: FragmentInstructionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentInstructionBinding.inflate(inflater, container,false)

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.shoeListFragment)
        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_instruction, container, false)
    }

}