package com.example.shoestoreappudacitynanodegree.shoeList

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestoreappudacitynanodegree.R
import com.example.shoestoreappudacitynanodegree.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {
    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        //viewModel = ViewModelProvider(this)[ShoeListViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)

        viewModel.shoes.observe(viewLifecycleOwner) { shoes ->
            binding.linearLayout.removeAllViews()

            shoes.forEach { shoe ->

                val nameTextView = TextView(context).apply {
                    text = getString(R.string.name_list, shoe.name)
                    textSize = 18f
                    setTypeface(null, Typeface.BOLD)
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        topMargin = 16
                    }
                }
                binding.linearLayout.addView(nameTextView)


                val brandTextView = TextView(context).apply {
                    text = getString(R.string.brand_list, shoe.brand)
                    textSize = 16f
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    )
                }
                binding.linearLayout.addView(brandTextView)


                val descriptionTextView = TextView(context).apply {
                    text = getString(R.string.description_list, shoe.description)
                    textSize = 14f
                }
                binding.linearLayout.addView(descriptionTextView)


                val sizeTextView = TextView(context).apply {
                    text = getString(R.string.size_list, shoe.size)
                    textSize = 12f
                }
                binding.linearLayout.addView(sizeTextView)
            }
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.shoeDetailsFragment)

        }

        return binding.root
        // return inflater.inflate(R.layout.fragment_shoe_list, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(R.id.loginFragment)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}