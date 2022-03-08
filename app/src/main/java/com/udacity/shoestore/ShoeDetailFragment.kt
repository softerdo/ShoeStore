package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetailFragment : Fragment() {

    private val newShoe = ShoeListViewModel()
    private val shoeName = input_shoe_name.text.toString()
    private val companyName = inputCompany.text.toString()
    private val shoeSize = inputShoeSize.text.toString()
    private val shoeDescription = inputDescription.text.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)


        //Listener to cancel the operation and go back to the shoeList
        binding.btnCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment))

        //Listener to save the details and go back to the shoeList and add a new entry to the viewModel
//        binding.btnSave.setOnContextClickListener {
//            //Adding a shoe
//            newShoe.addShoe(shoeName, shoeSize, companyName, shoeDescription)
//            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
//        }
        binding.btnSave.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment))


        return binding.root
    }



}