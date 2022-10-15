package com.udacity.shoestore

import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.LinkedList

class ActivityViewModel : ViewModel()
{
    val shoesData: LinkedList<Shoe> = LinkedList()

    fun addShoe(shoe: Shoe)
    {
        shoesData.add(shoe)
    }
}