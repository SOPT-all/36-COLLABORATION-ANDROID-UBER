package com.sopt.at.uber.feature.dummy.viewmodel

import androidx.lifecycle.ViewModel
import com.sopt.at.uber.domain.repository.DummyUberRepository
import com.sopt.at.uber.feature.dummy.DummyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DummyViewModel @Inject constructor(
    private val dummyUberRepository: DummyUberRepository
) : ViewModel() {
    private val _state = MutableStateFlow(DummyState())
    val state = _state.asStateFlow()
}