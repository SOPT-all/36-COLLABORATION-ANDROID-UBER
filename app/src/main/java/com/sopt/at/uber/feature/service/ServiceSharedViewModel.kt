package com.sopt.at.uber.feature.service

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.sopt.at.uber.core.type.LocationFieldType
import com.sopt.at.uber.domain.model.TaxiInfoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class ServiceSharedViewModel @Inject constructor() : ViewModel() {
    private val _selectedTaxi = MutableStateFlow<TaxiInfoModel?>(null)
    val selectedTaxi: StateFlow<TaxiInfoModel?> = _selectedTaxi

    private val _selectedDeparture = MutableStateFlow(TextFieldValue())
    val selectedDeparture: StateFlow<TextFieldValue> = _selectedDeparture

    private val _selectedDestination = MutableStateFlow(TextFieldValue())
    val selectedDestination: StateFlow<TextFieldValue> = _selectedDestination

    private val _selectedDate = MutableStateFlow(LocalDate.now())
    val selectedDate: StateFlow<LocalDate> = _selectedDate

    private val _selectedTime = MutableStateFlow(LocalTime.now())
    val selectedTime: StateFlow<LocalTime> = _selectedTime

    fun updateDeparture(departure: TextFieldValue) {
        _selectedDeparture.value = departure
    }

    fun updateDestination(destination: TextFieldValue) {
        _selectedDestination.value = destination
    }


    fun selectLocationAndPost(
        field: LocationFieldType,
        location: TextFieldValue,
        departure: TextFieldValue,
        destination: TextFieldValue,
        post: (String, String) -> Unit
    ) {
        when (field) {
            LocationFieldType.DEPARTURE -> updateDeparture(location)
            LocationFieldType.DESTINATION -> updateDestination(location)
        }

        val newDeparture = if (field == LocationFieldType.DEPARTURE) location else departure
        val newDestination = if (field == LocationFieldType.DESTINATION) location else destination

        if (newDeparture.text.isNotBlank() && newDestination.text.isNotBlank()) {
            post(newDeparture.text, newDestination.text)
        }
    }

    fun updatePickupDate(date: LocalDate) {
        _selectedDate.value = date
    }

    fun updatePickupTime(time: LocalTime) {
        _selectedTime.value = time
    }

    fun selectTaxi(taxi: TaxiInfoModel) {
        _selectedTaxi.value = taxi
    }
}