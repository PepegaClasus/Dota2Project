package com.example.dota2project.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dota2project.Repository.Repository
import javax.inject.Inject

@Suppress ("UNCHECKED_CAST")
class DotaViewModelFactory @Inject constructor(val repository: Repository): ViewModelProvider.NewInstanceFactory() {
    override fun <T: ViewModel?> create(modelClass : Class<T>):T {
        return DotaViewModel(repository) as T
    }
}