package com.example.navbaranalysisone.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navbaranalysisone.data.model.EndPtTwoModelItem
import com.example.navbaranalysisone.data.remote.ApiService
import com.example.navbaranalysisone.di.Api2Qualifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    @Api2Qualifier private val api2Service: ApiService,
): ViewModel() {
    private val _text = MutableLiveData<List<EndPtTwoModelItem>>()  // Change LiveData type
    val text: LiveData<List<EndPtTwoModelItem>> = _text

    fun getText() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = api2Service.getApi2()
                _text.postValue(listOf(result))
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}