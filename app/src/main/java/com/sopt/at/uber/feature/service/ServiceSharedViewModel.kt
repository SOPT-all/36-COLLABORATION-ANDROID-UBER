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

    fun selectTaxi(taxi: TaxiInfoModel) {
        _selectedTaxi.value = taxi
    }
}