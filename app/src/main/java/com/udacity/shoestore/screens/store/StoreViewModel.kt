package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.LinkedList

class StoreViewModel : ViewModel()
{
    private val _shoes = MutableLiveData<LinkedList<Shoe>>()
    val shoes: LiveData<LinkedList<Shoe>>
        get() = _shoes
    fun addShoesData(shoesData: LinkedList<Shoe>)
    {
        _shoes.value = shoesData
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("Felo", "ViewModel cleared")
    }
}