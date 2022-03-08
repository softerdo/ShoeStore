package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    var shoe = MutableLiveData<Shoe>()
    var shoeList = mutableListOf<Shoe>(
        Shoe("skate", 6.0, "Adidas", "Awesome colors"),
        Shoe("Run", 6.5, "Adidas", "Awesome colors"),
        Shoe("Suede", 7.0, "Puma", "Awesome colors"),
        Shoe("Ferrari", 7.5, "Puma", "Awesome colors")
    )

    init {
        showShoeList()
    }

    fun showShoeList(){
        for (item in shoeList.indices){
           println("Name: ${shoeList[item].name} \n" +
                    "Size: ${shoeList[item].size} \n" +
                    "Company: ${shoeList[item].company} \n" +
                    "Description: ${shoeList[item].description} \n")
        }
    }

    fun addShoe(name:String, size:Double, company:String, description:String):String{
        shoeList.add(Shoe(name, size, company, description))
        return shoeList.toString()
    }

}



//Shoe("Fit", 8.0, "Puma", "Awesome colors"),
//Shoe("Sport", 8.5, "Under Armour", "Awesome colors"),
//Shoe("Trail", 9.0, "Under Armour", "Awesome colors"),
//Shoe("Air", 4.0, "Nike", "Awesome colors"),
//Shoe("Pegasus", 5.0, "Nike", "Awesome colors"),
//Shoe("Campus", 5.5, "Adidas", "Awesome colors")