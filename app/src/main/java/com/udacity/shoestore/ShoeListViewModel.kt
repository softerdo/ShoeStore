package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    var shoe = MutableLiveData<Shoe>()
    private var shoeList = mutableListOf<Shoe>(
        Shoe("skate", "6.0", "Adidas", "Awesome colors"),
        Shoe("Run", "6.5", "Adidas", "Speedy Gonzalez"),
        Shoe("Suede", "7.0", "Puma", "No sweat"),
        Shoe("Ferrari", "7.5", "Puma", "Next level"),
        Shoe("Air", "7.0", "Nike", "Air Jordan"),
        Shoe("Green", "6.5", "Reebok", "Clean"),
        Shoe("Fit", "8.0", "Puma", "Comfortable")
    )

    init {
        showShoeList()
    }

    fun showShoeList():String{
            var combinedShoesData = ""
            for (item in shoeList.indices) {
                combinedShoesData = combinedShoesData.plus(
                    "Name: ${shoeList[item].name} \n" +
                            "Size: ${shoeList[item].size} \n" +
                            "Company: ${shoeList[item].company} \n" +
                            "Description: ${shoeList[item].description} \n" +
                            "----------------------------------------\n"
                )
            }
            return combinedShoesData
        }

    fun addShoe(name:String, size:String, company:String, description:String):String{
        shoeList.add(Shoe(name, size, company, description))
        return shoeList.toString()
    }

}



