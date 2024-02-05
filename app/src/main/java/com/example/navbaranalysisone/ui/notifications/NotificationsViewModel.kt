package com.example.navbaranalysisone.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navbaranalysisone.data.model.EndPtThreeModelItem
import com.example.navbaranalysisone.data.remote.ApiService
import com.example.navbaranalysisone.di.Api3Qualifier
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    @Api3Qualifier private val api3Service: ApiService,
): ViewModel() {

    private val _text = MutableLiveData<EndPtThreeModelItem>()
    val text: LiveData<EndPtThreeModelItem> = _text

    fun getText() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = api3Service.getApi3()
                _text.postValue(result)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}
