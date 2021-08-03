package com.example.dota2project.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2project.RemoteModel.Heroes
import com.example.dota2project.RemoteModel.MyMajors
import com.example.dota2project.RemoteModel.Teams
import com.example.dota2project.RemoteModel.profile
import com.example.dota2project.Repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DotaViewModel(val repository: Repository): ViewModel() {
    val scope = CoroutineScope(Dispatchers.IO)

    val heroesLive: MutableLiveData<MutableList<Heroes>> by lazy {
        MutableLiveData<MutableList<Heroes>>(mutableListOf())
    }

    val teamsLive: MutableLiveData<MutableList<Teams>> by lazy {
        MutableLiveData<MutableList<Teams>>(mutableListOf())
    }

    val majorsLive: MutableLiveData<MutableList<MyMajors>> by lazy {
        MutableLiveData<MutableList<MyMajors>>(mutableListOf())
    }

    var teamsForInfo: Teams? = null




    val playersLive: MutableLiveData<MutableList<profile>> by lazy {
        MutableLiveData<MutableList<profile>>(mutableListOf())
    }

    fun getHeroes(){
        viewModelScope.launch {

            val heroes = repository.getData()
            val list = heroesLive.value
            list?.addAll(heroes)
            heroesLive.postValue(list)

        }
    }






}