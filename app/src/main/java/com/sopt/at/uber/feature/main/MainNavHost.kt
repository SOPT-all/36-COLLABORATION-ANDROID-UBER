package com.sopt.at.uber.feature.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import com.sopt.at.uber.feature.account.navigation.accountGraph
import com.sopt.at.uber.feature.activity.navigation.activityGraph
import com.sopt.at.uber.feature.home.navigation.homeGraph
import com.sopt.at.uber.feature.house.navigation.houseGraph
import com.sopt.at.uber.feature.service.ServiceSharedViewModel
import com.sopt.at.uber.feature.service.history.navigation.historyGraph
import com.sopt.at.uber.feature.service.history.navigation.navigateToHistory
import com.sopt.at.uber.feature.service.information.navigation.informationGraph
import com.sopt.at.uber.feature.service.information.navigation.navigateToInformation
import com.sopt.at.uber.feature.service.location.navigation.locationGraph
import com.sopt.at.uber.feature.service.location.navigation.navigateToLocation
import com.sopt.at.uber.feature.service.reservation.navigation.navigateToReservation
import com.sopt.at.uber.feature.service.reservation.navigation.reservationGraph
import com.sopt.at.uber.feature.service.time.navigation.navigateToTime
import com.sopt.at.uber.feature.service.time.navigation.timeGraph
import com.sopt.at.uber.feature.service.vehicle.navigation.navigateToVehicle
import com.sopt.at.uber.feature.service.vehicle.navigation.vehicleGraph

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    modifier: Modifier = Modifier
) {
    val sharedViewModel: ServiceSharedViewModel = hiltViewModel()
    NavHost(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        navController = navigator.navController,
        startDestination = navigator.startDestination
    ) {
        homeGraph(
            modifier = modifier,
            navigateToReservation = navigator.navController::navigateToReservation,
        )
        reservationGraph(
            modifier = modifier,
            navigateToLocation = navigator.navController::navigateToLocation,
            navigateUp = navigator::navigateUp
        )
        locationGraph(
            modifier = modifier,
            navigateToTime = navigator.navController::navigateToTime,
            navigateUp = navigator::navigateUp
        )
        timeGraph(
            modifier = modifier,
            navigateToInformation = navigator.navController::navigateToInformation,
            navigateUp = navigator::navigateUp
        )
        informationGraph(
            modifier = modifier,
            sharedViewModel = sharedViewModel,
            navigateToHistory = navigator.navController::navigateToHistory,
            navigateToVehicle = navigator.navController::navigateToVehicle,
            navigateUp = navigator::navigateUp
        )
        vehicleGraph(
            modifier = modifier,
            sharedViewModel = sharedViewModel,
            navigateToInformation = navigator.navController::navigateToInformation,
            navigateUp = navigator::navigateUp,
        )
        historyGraph(
            modifier = modifier,
            navigateUp = navigator::navigateUp
        )

        houseGraph()
        activityGraph()
        accountGraph()

    }
}