package com.udacity.shoestore.screens.welcome_onboarding.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeOnboardingBinding

class WelcomeOnboardingFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome_onboarding, container, false)

        binding.btnNext.setOnClickListener {
            val action = WelcomeOnboardingFragmentDirections.actionWelcomeOnboardingFragmentToInstructionsOnboardingFragment()
            findNavController().navigate(action)
        }

        val appActivity = activity as AppCompatActivity

        appActivity.supportActionBar?.title = "Welcome"
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Felo", "destroy WelcomeOnboardingFragment")
    }
}