package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.*
import kotlinx.android.synthetic.main.fragment_shoe_list.*

class ShoeListFragment : Fragment() {

    //LiveData field
    private val viewModel by activityViewModels<ShoeListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list, container, false
        )
        binding.lifecycleOwner = this

        //Showing the menu
        setHasOptionsMenu(true)


        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            shoeList ->
            binding.listOfShoes.text = viewModel.showShoeList()
        })


        //Listener to navigate to the shoeDetail Fragment
        binding.fabShoeList.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment)
        )
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

//        binding.listOfShoes.text = myLisOfShoes.showShoeList()
//        val args: ShoeListFragmentArgs by navArgs()
//        val shoeName = args.shoeName
//        list_of_shoes_two.text = shoeName



//        listOfShoes.text = myLisOfShoes.showShoeList()
//Getting the values from ShoeDetailFragment
//        val args = this.arguments
//            if (args?.getStringArrayList("info") != null){
//        val myValues = requireArguments().getStringArrayList("info")
//            newShoe = myLisOfShoes.showShoeListWithArguments(myValues)
//        list_of_shoes_two.text = myValues.toString()
//Add a shoe and return to the ShoeListFragment
//            myLisOfShoes.addShoe(newShoe)
//            }