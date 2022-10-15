package com.udacity.shoestore.screens.store

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.StoreViewModel
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.TempShoe


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_details, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)

        binding.tempShoe = TempShoe("", "", "", "", mutableListOf("shoe_photo"))

        binding.btnCansel.setOnClickListener { findNavController().popBackStack() }
        binding.btnSave.setOnClickListener {
            if(validate())
            {
                val shoe = binding.tempShoe!!.toShoe()
                (activity as MainActivity).activityViewModel.addShoe(shoe)
                findNavController().popBackStack()
            }
            else
            {
                binding.txtError.text = getString(R.string.please_enter_add_data)
            }
        }
        return binding.root
    }
    private fun validate(): Boolean
    {
        return binding.etName.text.isNotEmpty() && binding.etName.text.isNotBlank() &&
                binding.etSize.text.isNotEmpty() && binding.etSize.text.isNotBlank() &&
                binding.etDescription.text.isNotEmpty() && binding.etDescription.text.isNotBlank() &&
                binding.etCompany.text.isNotEmpty() && binding.etCompany.text.isNotBlank()
    }
}