package com.udacity.shoestore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel() : ViewModel() {

    var shoe = Shoe()
    var shoeLiveData = MutableLiveData<List<Shoe>>()
    var shoeList = mutableListOf<Shoe>()

    fun addShoe(){
        shoeList.add(shoe)
        shoeLiveData.value = shoeList

    }

    fun getShoeList(){
//        shoeLiveData.value = shoeList
    }
}