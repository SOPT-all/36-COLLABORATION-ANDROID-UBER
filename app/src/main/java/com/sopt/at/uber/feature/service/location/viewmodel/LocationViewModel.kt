package com.sopt.at.uber.feature.service.location.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.at.uber.core.type.LocationFieldType
import com.sopt.at.uber.core.util.parseErrorMessage
import com.sopt.at.uber.domain.model.SearchKeywordModel
import com.sopt.at.uber.domain.repository.LocationRepository
import com.sopt.at.uber.feature.service.location.LocationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: LocationRepository
) : ViewModel() {
    private val _locationState = MutableStateFlow(LocationState())
    val locationState: StateFlow<LocationState> = _locationState

    private fun updateCurrentSearchList(list: List<SearchKeywordModel>) {
        _locationState.update {
            _locationState.value.copy(
                currentSearchList = list
            )
        }
    }

    fun updateActiveTextField(activeField: LocationFieldType) {
        _locationState.update {
            _locationState.value.copy(
                activeField = activeField
            )
        }
    }

    private fun updateErrorMessage(message: String?) {
        _locationState.update {
            _locationState.value.copy(
                errorMessage = message
            )
        }
    }

    fun getSearchList() {
        viewModelScope.launch {
            repository.getSearchList().onSuccess { data ->
                updateCurrentSearchList(data.searchKeywords)
                Log.d("getSearchList", data.toString())
            }
                .onFailure { error ->
                    val errorMessage = error.parseErrorMessage()
                    updateErrorMessage(errorMessage)
                }
        }
    }

    fun postLocation(departure: String, destination: String, navigateToTime: () -> Unit) {
        viewModelScope.launch {
            repository.postLocation(departure, destination).onSuccess {
                navigateToTime()
            }
                .onFailure { error ->
                    val errorMessage = error.parseErrorMessage()
                    updateErrorMessage(errorMessage)
                }
        }
    }

    fun deleteSearchHistoryWithId(id: Long) {
        viewModelScope.launch {
            repository.deleteSearchHistoryWithId(id).onSuccess {
                val currentList = _locationState.value.currentSearchList.toMutableList()
                currentList.removeAll { it.id == id }
                updateCurrentSearchList(currentList)
            }
                .onFailure { error ->
                    val errorMessage = error.parseErrorMessage()
                    updateErrorMessage(errorMessage)
                }
        }
    }
}