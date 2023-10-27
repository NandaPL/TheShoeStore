package com.example.android.theshoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.theshoestore.R
import com.example.android.theshoestore.model.Shoes
import com.example.android.theshoestore.databinding.FragmentDetailBinding
import com.example.android.theshoestore.viewmodel.StoreListViewModel

class DetailFragment : Fragment() {
    private lateinit var dataBinding: FragmentDetailBinding
    private lateinit var mViewModel: StoreListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )

        dataBinding.lifecycleOwner = viewLifecycleOwner
        mViewModel = ViewModelProvider(this)[StoreListViewModel::class.java]

        dataBinding.apply {
            saveButton.setOnClickListener {
                saveShoe()
            }
            cancelButton.setOnClickListener { backToListFragment() }
        }

        return dataBinding.root
    }

    private fun saveShoe() {
        val shoeName = dataBinding.shoeNameEditText.text.toString()
        val shoeCompany = dataBinding.shoeCompanyEditText.text.toString()
        val shoeSize = dataBinding.shoeNumberEditText.text.toString()
        val shoeDescription = dataBinding.shoeDescriptionEditText.text.toString()
        val newShoe = Shoes(
            shoeName,
            shoeCompany,
            shoeSize.toDouble(),
            shoeDescription
        )

        if(newShoe != null){
            mViewModel.addShoeToList(newShoe)
            Toast.makeText(requireContext(), "adicionado", Toast.LENGTH_LONG).show()
            backToListFragment()
        } else {
            Toast.makeText(requireContext(), "Nulo", Toast.LENGTH_LONG).show()
        }

    }

    private fun backToListFragment() {
        findNavController().navigate(R.id.action_detailFragment_to_storeFragment)
    }


}