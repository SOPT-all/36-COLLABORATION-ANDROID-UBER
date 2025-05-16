package com.sopt.at.uber.feature.service.location

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.feature.service.location.component.CurrentSearchHeader
import com.sopt.at.uber.feature.service.location.component.CurrentSearchItem
import com.sopt.at.uber.feature.service.location.component.LocationTextField
import okhttp3.internal.immutableListOf

enum class LocationField { DEPARTURE, DESTINATION }

@Composable
fun LocationScreen(
    modifier: Modifier = Modifier,
    navigateToTime: () -> Unit,
    navigateUp: () -> Unit,
) {
    var departure by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }
    val currentSearchList = immutableListOf(
        Triple("더좋은세상", "서울특별시 송파구 올림픽로35가길 10", "05.06"),
        Triple("더좋은세상", "서울특별시 송파구 올림픽로35가길 10", "05.06"),
        Triple("더좋은세상", "서울특별시 송파구 올림픽로35가길 10", "05.06"),
        Triple("더좋은세상", "서울특별시 송파구 올림픽로35가길 10", "05.06")
    )
    var activeField by remember { mutableStateOf(LocationField.DEPARTURE) }

    val focusManager = LocalFocusManager.current
    val focusRequesterDeparture = remember { FocusRequester() }
    val focusRequesterDestination = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequesterDeparture.requestFocus()
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        // TODO: 종훈이가 구현한 TopBar 붙이기
        item {
            Spacer(Modifier.height(10.dp))
        }
        item {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = colors.bgWhite)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                LocationTextField(
                    value = departure,
                    onValueChange = { departure = it },
                    hint = stringResource(R.string.location_hint_departure),
                    leadingContent = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_departures),
                            contentDescription = "",
                            tint = colors.textSub3
                        )
                    },
                    onFocusChange = { focused ->
                        if (focused) activeField = LocationField.DEPARTURE
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
                    value = destination,
                    onValueChange = { destination = it },
                    hint = stringResource(R.string.location_hint_destination),
                    leadingContent = {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_destination),
                            contentDescription = stringResource(R.string.location_hint_destination),
                            tint = colors.textSub3
                        )
                    },
                    onFocusChange = { focused ->
                        if (focused) activeField = LocationField.DESTINATION
                    },
                    focusRequester = focusRequesterDestination,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                            navigateToTime()
                        }
                    )
                )
            }
        }
        item {
            Spacer(Modifier.height(20.dp))
        }
        item {
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = colors.bgGray,
                thickness = 6.dp
            )
        }
        item {
            CurrentSearchHeader()
        }
        items(currentSearchList) { item ->
            val selectedLocation = item.first
            CurrentSearchItem(
                locationName = item.first,
                locationAddress = item.second,
                dateString = item.third,
                onDeleteClick = {},
                onSectionClick = {
                    when (activeField) {
                        LocationField.DEPARTURE -> departure = selectedLocation
                        LocationField.DESTINATION -> destination = selectedLocation
                    }
                    focusManager.clearFocus()
                    if (departure.isNotBlank() && destination.isNotBlank()) {
                        navigateToTime()
                    }
                }
            )
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