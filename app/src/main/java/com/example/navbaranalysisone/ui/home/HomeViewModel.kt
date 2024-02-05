package com.example.navbaranalysisone.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navbaranalysisone.data.model.endptone.EndPtOneModelItem
import com.example.navbaranalysisone.data.remote.ApiDetails
import com.example.navbaranalysisone.data.remote.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class HomeViewModel @Inject constructor(
    @Named("api1") private val api1Service: ApiService,
): ViewModel() {

    private val _text = MutableLiveData<List<EndPtOneModelItem>>()
    val text: LiveData<List<EndPtOneModelItem>> = _text

    fun getText() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = api1Service.getApi1()
            if (result.isNotEmpty()) {
                _text.postValue(result)
            }
        }
    }
}