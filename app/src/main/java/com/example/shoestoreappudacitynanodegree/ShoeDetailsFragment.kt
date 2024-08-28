package com.example.shoestoreappudacitynanodegree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreappudacitynanodegree.databinding.FragmentShoeDetailsBinding
import com.example.shoestoreappudacitynanodegree.model.Shoe
import com.example.shoestoreappudacitynanodegree.shoeList.ShoeListViewModel


class ShoeDetailsFragment : Fragment() {
    private var _binding: FragmentShoeDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShoeListViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)

        //  initialize the  shoe object
        val shoe = Shoe("", "", "", "")
        // Bind the Shoe object to the layout
        binding.shoe = shoe

        setupButtonListeners()
        return binding.root
        //return inflater.inflate(R.layout.fragment_shoe_details, container, false)
    }

    // set up listeners for both save button and cancel button and navigate appropriately on whichever is selected
    private fun setupButtonListeners() {
        binding.buttonSave.setOnClickListener {
            saveShoe()
        }
        binding.buttonCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    // saves the details of the new shoe information entered by the users
    private fun saveShoe() {
// added two-way data binding to make the code cleaner and more readable. i also added validation to the views.
        val shoe = binding.shoe
        if (shoe != null && shoe.name.isNotBlank() && shoe.brand.isNotBlank() &&
            shoe.size.isNotBlank() && shoe.description.isNotBlank()
        ) {
            viewModel.addNewShoeDetails(shoe)
            findNavController().navigateUp()
        } else {
            Toast.makeText(requireContext(), " $shoe Please fill all fields", Toast.LENGTH_SHORT)
                .show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}