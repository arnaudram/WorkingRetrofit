package com.example.workingretrofit.imagelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.workingretrofit.networkservice.WallPaperCaveApiService

class ListImageViewModelFactory:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(ListImageViewModel::class.java)){
           return ListImageViewModel()as T
       }
        else throw IllegalArgumentException("unknown viewModel")
    }
}