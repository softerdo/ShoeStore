package com.udacity.shoestore

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_list.*

class ShoeListFragment : Fragment() {
    //LiveData field
    private lateinit var viewModel: ShoeListViewModel
    private val myLisOfShoes = ShoeListViewModel()

    private val shoeListViewModel: ShoeListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list, container, false)

        //Showing the menu
        setHasOptionsMenu(true)

        //Referencing the viewModel
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        //Showing the list of shoes
        binding.listOfShoes.text = myLisOfShoes.showShoeList().toString()

//        shoeListViewModel.myShoeModel.observe(viewLifecycleOwner, Observer {
//            binding.listOfShoesName.text = it.company
//        })
        //Listener to navigate to the shoeDetail Fragment
        binding.fabShoeList.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))


        return binding.root
    }

    //This inflates the menu in this fragment
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }
    //Takes me to the desired destination
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}