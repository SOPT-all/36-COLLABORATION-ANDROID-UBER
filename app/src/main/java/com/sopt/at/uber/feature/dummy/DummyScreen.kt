package com.sopt.at.uber.feature.dummy

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.at.uber.feature.dummy.viewmodel.DummyViewModel

@Composable
fun DummyScreen(
    modifier: Modifier = Modifier,
    viewModel: DummyViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
}