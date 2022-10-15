package com.udacity.shoestore.screens.instructions_onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsOnboardingBinding
import com.udacity.shoestore.models.Shoe


class InstructionsOnboardingFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions_onboarding, container, false)

        binding.btnFinish.setOnClickListener {

            val action = InstructionsOnboardingFragmentDirections.actionInstructionsOnboardingFragmentToListingFragment3()
            findNavController().navigate(action)
        }
        val appActivity = activity as AppCompatActivity

        appActivity.supportActionBar?.title = "Instruction"
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Felo", "Destroy InstructionsOnboardingFragment")
    }

}