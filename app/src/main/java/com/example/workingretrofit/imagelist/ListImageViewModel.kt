package com.example.workingretrofit.imagelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.workingretrofit.model.EntityNetwork
import com.example.workingretrofit.networkservice.NetWork
import kotlinx.coroutines.*

enum class LoadStatus {
    LOADING,
    ERROR,
    DONE
}

class ListImageViewModel : ViewModel() {
    private val _responseFromNetWork = MutableLiveData<List<EntityNetwork>>()
    val responseFromNetWork: LiveData<List<EntityNetwork>>
        get() = _responseFromNetWork

    //status
    private val _status = MutableLiveData<LoadStatus>()
    val status: LiveData<LoadStatus>
        get() = _status
    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getImages() {
        uiScope.launch {

            try {
                _status.value=LoadStatus.LOADING
                val job = NetWork.webService.getProperties().await()
                _responseFromNetWork.value = job
                _status.value=LoadStatus.DONE
            } catch (e: Exception) {
                _status.value=LoadStatus.ERROR
            }


        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}