package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable

class TempShoe
{
    var name: String
    var size: String
    var company: String
    var description: String
    var images: List<String>

    constructor(name: String, size: String, company: String, description: String, images: List<String>)
    {
        this.name = name
        this.images = images
        this.company = company
        this.size = size
        this.description = description
    }
    fun toShoe(): Shoe
    {
        return Shoe(this.name, this.size.toDouble(), this.company, this.description, this.images)
    }

}