package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.stream.Collectors.toCollection

class ShoeListViewModel: ViewModel() {

    private var _shoes = MutableLiveData<List<Shoe>>()
    val shoes : LiveData<List<Shoe>>
        get() = _shoes

    private var shoeList = mutableListOf<Shoe>(
        Shoe("skate", "6.0", "Adidas", "Awesome colors"),
        Shoe("Run", "6.5", "Adidas", "Speedy Gonzalez"),
        Shoe("Suede", "7.0", "Puma", "No sweat"),
        Shoe("Ferrari", "7.5", "Puma", "Next level"),
        Shoe("Air", "7.0", "Nike", "Air Jordan"),
        Shoe("Green", "6.5", "Reebok", "Clean"),
        Shoe("Fit", "8.0", "Puma", "Comfortable"),
        Shoe("Run", "6.5", "Adidas", "Speedy Gonzalez")
    )
    init {
        _shoes.value = shoeList

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
    fun showShoeListWithArguments(args: ArrayList<String>):String{
        var combinedData = ""
        for (item in args){
            combinedData = combinedData.plus(
                args[0] + args[1] + args[2] + args[3]
            )
        }
        return combinedData
    }

    fun addShoe(newShoe: Shoe){
        shoeList.add(newShoe)
    }

}



