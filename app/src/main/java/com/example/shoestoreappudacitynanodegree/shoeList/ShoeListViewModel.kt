package com.example.shoestoreappudacitynanodegree.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreappudacitynanodegree.model.Shoe

class ShoeListViewModel: ViewModel() {

    private val _shoes = MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes


    init {
        loadShoes()
    }

    private fun loadShoes() {
        _shoes.value = listOf(
            Shoe("Sneakers", "Nike", "Men's Running Shoe", "41"),
            Shoe("Boots", "Timberland", "Classic Boots", "43"),
            Shoe("Heels", "Zara", "Faux Slingback Shoe", "39"),
            Shoe("Canvas", "Adidas", "Men's Bravada", "42"),
            Shoe("Velvet Loafer", "Gees Collect", "Men's Shoe", "45"),
        )
    }


    fun addNewShoeDetails(shoe: Shoe) {
        val currentList = _shoes.value?.toMutableList() ?: mutableListOf()
        currentList.add(shoe)
        _shoes.value = currentList
    }
}

