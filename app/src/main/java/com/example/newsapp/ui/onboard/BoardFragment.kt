package com.example.newsapp.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentBoardBinding

class BoardFragment : Fragment() {
    private lateinit var binding:FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=BoardAdapter(requireContext(),findNavController(),binding)
        binding.viewPager.adapter=adapter
        binding.dotsIndicator.attachTo(binding.viewPager)
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object:OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }

        })

    }
}