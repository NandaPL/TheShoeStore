package com.example.android.theshoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.theshoestore.R
import com.example.android.theshoestore.databinding.FragmentStoreBinding
import com.example.android.theshoestore.databinding.ShoeItemBinding
import com.example.android.theshoestore.viewmodel.StoreListViewModel

class ShoeListStoreFragment : Fragment() {
    private lateinit var dataBinding: FragmentStoreBinding
    private lateinit var mViewModel: StoreListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_store,
            container,
            false
        )
        setHasOptionsMenu(true)

        dataBinding.lifecycleOwner = viewLifecycleOwner
        mViewModel = ViewModelProvider(this)[StoreListViewModel::class.java]

        mViewModel.shoeList.observe(viewLifecycleOwner, Observer {shoes ->
            dataBinding.shoesList.removeAllViews()

            shoes.forEach {
                val shoeItem = ShoeItemBinding.inflate(LayoutInflater.from(requireContext()), dataBinding.shoesList, false)

                shoeItem.shoeName.text = it.name
                shoeItem.shoeCompany.text = it.company
                shoeItem.shoeSize.text = it.size.toString()
                shoeItem.shoeDescription.text = it.description

                dataBinding.shoesList.addView(shoeItem.root)
            }

        })

        dataBinding.shoeDetailButton.setOnClickListener {
            findNavController().navigate(R.id.action_storeFragment_to_detailFragment)
        }

        return dataBinding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_shoe_list, menu)
    }

    /**
     * Makes it so that in case of logout, this activity will become the start
     * of a new task in this history stack
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(R.id.action_storeFragment_to_loginFragment)
        return super.onOptionsItemSelected(item)
    }

}