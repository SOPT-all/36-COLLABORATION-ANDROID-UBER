package com.sopt.at.uber.feature.service.location

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.util.toast
import com.sopt.at.uber.feature.service.ServiceSharedViewModel
import com.sopt.at.uber.feature.service.information.component.TopBar
import com.sopt.at.uber.feature.service.location.component.CurrentSearchHeader
import com.sopt.at.uber.feature.service.location.component.CurrentSearchItem
import com.sopt.at.uber.feature.service.location.component.LocationTextField
import com.sopt.at.uber.feature.service.location.viewmodel.LocationViewModel

enum class LocationField { DEPARTURE, DESTINATION }

@Composable
fun LocationScreen(
    modifier: Modifier = Modifier,
    navigateToTime: () -> Unit,
    navigateUp: () -> Unit,
    sharedViewModel: ServiceSharedViewModel = hiltViewModel(),
    locationViewModel: LocationViewModel = hiltViewModel()
) {
    val state by locationViewModel.locationState.collectAsStateWithLifecycle()
    val selectedDeparture by sharedViewModel.selectedDeparture.collectAsStateWithLifecycle()
    val selectedDestination by sharedViewModel.selectedDestination.collectAsStateWithLifecycle()

    val focusManager = LocalFocusManager.current
    val focusRequesterDeparture = remember { FocusRequester() }
    val focusRequesterDestination = remember { FocusRequester() }

    val context = LocalContext.current

    LaunchedEffect(state.errorMessage) {
        state.errorMessage?.let {
            context.toast(it, Toast.LENGTH_SHORT)
        }
    }

    LaunchedEffect(Unit) {
        locationViewModel.getSearchList()
        focusRequesterDeparture.requestFocus()
    }
    Column(
        modifier = modifier.fillMaxSize()
            .background(color = colors.bgWhite)
    ) {
        TopBar(
            onBackClick = navigateUp,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
            title = "차량 서비스 예약"
        )
        Spacer(Modifier.height(10.dp))
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = colors.bgWhite)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            LocationTextField(
                value = selectedDeparture,
                onValueChange = { sharedViewModel.updateDeparture(it) },
                hint = stringResource(R.string.location_hint_departure),
                leadingContent = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_departures),
                        contentDescription = "",
                        tint = colors.textSub3
                    )
                },
                onFocusChange = { focused ->
                    if (focused) locationViewModel.updateActiveTextField(LocationField.DEPARTURE)
                },
                focusRequester = focusRequesterDeparture,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusRequesterDestination.requestFocus()
                    }
                )
            )
            LocationTextField(
                value = selectedDestination,
                onValueChange = { sharedViewModel.updateDestination(it) },
                hint = stringResource(R.string.location_hint_destination),
                leadingContent = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_destination),
                        contentDescription = stringResource(R.string.location_hint_destination),
                        tint = colors.textSub3
                    )
                },
                onFocusChange = { focused ->
                    if (focused) locationViewModel.updateActiveTextField(LocationField.DESTINATION)
                },
                focusRequester = focusRequesterDestination,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        focusManager.clearFocus()
                        if (selectedDeparture.isNotBlank() && selectedDestination.isNotBlank())
                            locationViewModel.postLocation(
                                selectedDeparture,
                                selectedDestination,
                                navigateToTime
                            )
                    }
                )
            )
        }
        Spacer(Modifier.height(20.dp))
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = colors.bgGray,
            thickness = 6.dp
        )
        CurrentSearchHeader(
            onDeleteClick = {
                // TODO: 시현이가 전체 삭제 연결
            }
        )
        LazyColumn {
            items(state.currentSearchList, key = { it.id }) { item ->
                val selectedLocation = item.location
                CurrentSearchItem(
                    locationName = item.location,
                    locationAddress = item.address,
                    dateString = item.date,
                    onDeleteClick = {
                        locationViewModel.deleteSearchHistoryWithId(item.id)
                    },
                    onSectionClick = {
                        when (state.activeField) {
                            LocationField.DEPARTURE -> sharedViewModel.updateDeparture(
                                selectedLocation
                            )

                            LocationField.DESTINATION -> sharedViewModel.updateDestination(
                                selectedLocation
                            )
                        }
                        focusManager.clearFocus()
                    }
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun LocationScreenPreview() {
    LocationScreen(
        navigateToTime = {},
        navigateUp = {}
    )
}