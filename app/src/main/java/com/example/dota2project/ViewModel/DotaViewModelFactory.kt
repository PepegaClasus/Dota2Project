package com.example.dota2project.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dota2project.Repository.DotaRep
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class DotaViewModelFactory @Inject constructor(val dotaRep: DotaRep) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DotaViewModel(dotaRep) as T
    }
}