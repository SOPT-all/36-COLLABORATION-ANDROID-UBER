package com.sopt.at.uber.feature.service.reservation.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.Route
import com.sopt.at.uber.feature.service.reservation.ReservationScreen
import kotlinx.serialization.Serializable

fun NavController.navigateToReservation(navOptions: NavOptions? = null) {
    navigate(Reservation, navOptions)
}

fun NavGraphBuilder.reservationGraph(
    modifier: Modifier = Modifier,
    navigateToLocation: () -> Unit,
    navigateUp: () -> Unit
) {
    composable<Reservation> {
        ReservationScreen(
            modifier = modifier,
            navigateToLocation = navigateToLocation,
            navigateUp = navigateUp
        )
    }
}

@Serializable
data object Reservation : Route