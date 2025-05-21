package com.sopt.at.uber.feature.service.vehicle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.at.uber.domain.model.VehicleModel
import com.sopt.at.uber.domain.repository.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(
    private val repository: VehicleRepository
) : ViewModel() {

    private val _vehicleState = MutableStateFlow<VehicleModel?>(null)
    val vehicleState: StateFlow<VehicleModel?> = _vehicleState

    fun getTaxiLists() {
        viewModelScope.launch {
            repository.getTaxiLists()
                .onSuccess { response ->
                    _vehicleState.value = response
                }
        }
    }


}
