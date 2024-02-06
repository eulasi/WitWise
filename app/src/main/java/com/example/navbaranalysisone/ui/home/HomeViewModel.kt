package com.example.navbaranalysisone.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navbaranalysisone.data.model.EndPtOneModelItem
import com.example.navbaranalysisone.data.remote.ApiService
import com.example.navbaranalysisone.di.Api1Qualifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class HomeViewModel @Inject constructor(
    @Api1Qualifier private val api1Service: ApiService,
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