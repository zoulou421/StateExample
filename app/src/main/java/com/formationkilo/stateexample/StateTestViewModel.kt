package com.formationkilo.stateexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateTestViewModel:ViewModel() {

    private val _name=MutableLiveData<String>()
    val name: LiveData<String> =_name

    fun onNameUpdate(newName:String){
        _name.value=newName
    }
}