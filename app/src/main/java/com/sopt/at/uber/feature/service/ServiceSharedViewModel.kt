package com.sopt.at.uber.feature.service

import androidx.lifecycle.ViewModel
import com.sopt.at.uber.domain.model.TaxiInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ServiceSharedViewModel @Inject constructor() : ViewModel() {
    private val _selectedTaxi = MutableStateFlow<TaxiInfoModel?>(null)
    val selectedTaxi: StateFlow<TaxiInfoModel?> = _selectedTaxi

    private val _selectedDeparture = MutableStateFlow("")
    val selectedDeparture: StateFlow<String> = _selectedDeparture

    private val _selectedDestination = MutableStateFlow("")
    val selectedDestination: StateFlow<String> = _selectedDestination

    fun updateDeparture(departure: String) {
        _selectedDeparture.value = departure
    }

    fun updateDestination(destination: String) {
        _selectedDestination.value = destination
    }
    fun selectTaxi(taxi: TaxiInfoModel) {
        _selectedTaxi.value = taxi
    }
}