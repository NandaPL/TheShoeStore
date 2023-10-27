package com.example.android.theshoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.theshoestore.model.Shoes

class StoreListViewModel: ViewModel() {
   private val _shoeList = MutableLiveData<List<Shoes>>()
    val shoeList: LiveData<List<Shoes>>
        get() = _shoeList

    init {
        createShoeList()
    }

    private fun createShoeList(){
        _shoeList.value = mutableListOf(
            Shoes("Lite Racer", "ADIDAS", 42.0, "In ideal for day-to-day use, it can be your new favorite casual sneaker!"),
            Shoes("Converse High", "ALL STAR", 34.0, "It's a nice and conformable sneaker for daily life.")
        )
    }

    fun addShoeToList(shoe: Shoes){
        val currentShoeList = _shoeList.value?.toMutableList()?: mutableListOf()
        currentShoeList.add(shoe)
        _shoeList.value = currentShoeList
    }

}