package com.sopt.at.uber.feature.service.reservation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.uber.R
import com.sopt.at.uber.core.component.CustomCarItem
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.colors
import com.sopt.at.uber.core.designsystem.ui.theme.AppTheme.typography
import com.sopt.at.uber.core.type.CustomCarType
import com.sopt.at.uber.core.type.ReservationNoticeType
import com.sopt.at.uber.feature.service.reservation.component.ReservationLocationButton
import com.sopt.at.uber.feature.service.reservation.component.ReservationNoticeItem
import com.sopt.at.uber.feature.service.reservation.component.ReservationTopBar
import kotlinx.collections.immutable.toImmutableList

@Composable
fun ReservationScreen(
    modifier: Modifier = Modifier,
    navigateToLocation: () -> Unit,
    navigateUp: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = colors.bgGray)
    ) {
        Column(
            modifier = modifier
                .background(color = colors.bgWhite)
        ) {
            ReservationTopBar(
                onBackButtonClick = navigateUp
            )
            Spacer(Modifier.height(10.dp))

            LocationSelectionSection(
                onLocationClick = navigateToLocation
            )

            Spacer(Modifier.height(20.dp))
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = colors.bgGray,
                thickness = 6.dp
            )
            Spacer(Modifier.height(20.dp))


            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ReservationNoticeSection()

                Spacer(Modifier.height(20.dp))
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    color = colors.bgGraySub,
                    thickness = 1.dp
                )
                Spacer(Modifier.height(20.dp))

                CarTypeSection()
            }
        }
    }
}

@Composable
private fun LocationSelectionSection(
    onLocationClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colors.bgWhite)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ReservationLocationButton(
            hint = stringResource(R.string.location_hint_departure),
            leadingContent = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_departures),
                    contentDescription = "",
                    tint = colors.textSub3
                )
            },
            onLocationClick = onLocationClick
        )
        ReservationLocationButton(
            hint = stringResource(R.string.location_hint_destination),
            leadingContent = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_destination),
                    contentDescription = "",
                    tint = colors.textSub3
                )
            },
            onLocationClick = onLocationClick
        )
    }
}

@Composable
private fun ReservationNoticeSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        ReservationNoticeType.entries.toImmutableList().forEach { type ->
            key(type.description) {
                ReservationNoticeItem(
                    type = type
                )
            }
        }
    }
}

@Composable
private fun CarTypeSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.reservation_subTitle),
            style = typography.title4B18.merge(color = colors.textPrimary),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colors.bgGray)
                .padding(vertical = 20.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomCarType.entries.toImmutableList().forEach { type ->
                CustomCarItem(
                    type = type
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewReservationScreen() {
    ReservationScreen(
        navigateToLocation = {},
        navigateUp = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLocationSelectionSection() {
    LocationSelectionSection(
        onLocationClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewReservationNoticeSection() {
    ReservationNoticeSection()
}

@Preview(showBackground = true)
@Composable
fun PreviewCarTypeSelectionSection() {
    CarTypeSection()
}

@Preview(showBackground = true)
@Composable
private fun ReservationScreenPreview() {
    ReservationScreen(
        navigateToLocation = {},
        navigateUp = {}
    )
}