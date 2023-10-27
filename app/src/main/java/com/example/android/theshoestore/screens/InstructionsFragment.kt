package com.example.android.theshoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.android.theshoestore.R
import com.example.android.theshoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var dataBinding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_instructions,
            container,
            false
        )

        dataBinding.initializeButton.setOnClickListener {
            findNavController().navigate(R.id.action_instructionsFragment_to_storeFragment)
        }

        return dataBinding.root
    }
}