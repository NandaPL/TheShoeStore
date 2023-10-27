package com.example.android.theshoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.android.theshoestore.R
import com.example.android.theshoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var dataBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        clickListener()

        return dataBinding.root
    }

    private fun clickListener(){
        dataBinding.apply {
            loginButton.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }

            newLoginButton.setOnClickListener{
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
    }

}