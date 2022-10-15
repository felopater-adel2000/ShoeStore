package com.udacity.shoestore.screens.store

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.StoreViewModel
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.models.Shoe

class ListingFragment : Fragment() {

    private lateinit var binding: FragmentListingBinding
    lateinit var viewModel: StoreViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_listing, container, false)

        viewModel = ViewModelProvider(this)[StoreViewModel::class.java]
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        viewModel.addShoesData((activity as MainActivity).activityViewModel.shoesData)

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            Log.i("Felo", "Observe Shoes")
            for(item in shoes)
            {
                addShoeItem(item)
            }
        })

        binding.fabAddShow.setOnClickListener{
            val action = ListingFragmentDirections.actionListingFragment3ToDetailsFragment()
            findNavController().navigate(action)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    fun addShoeItem(shoe: Shoe)
    {
        val name: TextView = TextView(context)
        name.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        val size: TextView = TextView(context)
        size.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        val company: TextView = TextView(context)
        company.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        val discreption: TextView = TextView(context)
        discreption.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        val image = ImageView(context)
        image.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        name.text = shoe.name
        size.text = shoe.size.toString()
        company.text = shoe.company
        discreption.text = shoe.description
        image.setImageResource(resources.getIdentifier(shoe.images[0], "drawable", activity!!.packageName))
        image.layoutParams.width = 200
        image.layoutParams.height = 200


        binding.linearList.addView(name)
        binding.linearList.addView(size)
        binding.linearList.addView(company)
        binding.linearList.addView(discreption)
        binding.linearList.addView(image)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController()) || super.onOptionsItemSelected(item)
    }

}