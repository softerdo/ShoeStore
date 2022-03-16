package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetailFragment : Fragment() {
    //LiveData field
    private val viewModel by activityViewModels<ShoeListViewModel>()
    lateinit var shoeName: String
    lateinit var companyName:String
    lateinit var shoeSize:String
    lateinit var shoeDescription:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_detail, container, false)

        //Listener to cancel the operation and go back to the shoeList
        binding.btnCancel.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment))

        binding.btnSave.setOnClickListener { view: View ->
            shoeName = input_shoe_name.text.toString()
            companyName = inputCompany.text.toString()
            shoeSize = inputShoeSize.text.toString()
            shoeDescription = inputDescription.text.toString()

            //Validating the form
            if (input_shoe_name.text.isNotEmpty()){
                viewModel.addShoe(Shoe(shoeName, companyName, shoeSize, shoeDescription))
                Navigation.findNavController(view).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            }else{
                Toast.makeText(activity, "Please fill in the complete form!", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

}
/*
//            Getting the input from the EditableText views
shoeName = binding.inputShoeName.text.toString()
shoeSize = binding.inputShoeSize.text.toString()
companyName = binding.inputCompany.text.toString()
shoeDescription = binding.inputDescription.text.toString()

//            saving the information into an array
val information = arrayListOf<String>(shoeName, shoeSize, companyName, shoeDescription)
//            Passing the values to the ShoeListFragment in a bundle
val bundle = Bundle()
bundle.putStringArrayList("info", information)
val fragment = ShoeListFragment()
fragment.arguments = bundle
parentFragmentManager.beginTransaction().replace(R.id.myNavHostFragment, fragment).commit()

 */