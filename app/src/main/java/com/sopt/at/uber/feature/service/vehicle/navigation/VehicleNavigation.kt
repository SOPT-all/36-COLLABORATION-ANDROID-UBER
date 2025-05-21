package com.sopt.at.uber.feature.service.vehicle.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.Route
import com.sopt.at.uber.feature.service.ServiceSharedViewModel
import com.sopt.at.uber.feature.service.vehicle.VehicleScreen
import kotlinx.serialization.Serializable

fun NavController.navigateToVehicle(navOptions: NavOptions? = null) {
    navigate(Vehicle, navOptions)
}

fun NavGraphBuilder.vehicleGraph(
    modifier: Modifier,
    sharedViewModel: ServiceSharedViewModel,
    navigateToInformation: () -> Unit,
    navigateUp: () -> Unit,
) {
    composable<Vehicle>{
        VehicleScreen(
            sharedViewModel = sharedViewModel,
            navigateToInformation = navigateToInformation,
            navigateUp = navigateUp
        )
    }
}


@Serializable
data object Vehicle : Route