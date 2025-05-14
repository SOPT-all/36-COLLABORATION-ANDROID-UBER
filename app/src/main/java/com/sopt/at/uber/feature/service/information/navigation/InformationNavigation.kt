package com.sopt.at.uber.feature.service.information.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.Route
import com.sopt.at.uber.feature.service.information.InformationScreen
import kotlinx.serialization.Serializable

fun NavController.navigateToInformation(navOptions: NavOptions? = null) {
    navigate(Information, navOptions)
}

fun NavGraphBuilder.informationGraph(
    modifier: Modifier = Modifier,
    navigateToVehicle: () -> Unit,
    navigateUp: () -> Unit

) {
    composable<Information> {
        InformationScreen(
            modifier = modifier,
            navigateToVehicle = navigateToVehicle,
            navigateUp = navigateUp
        )
    }
}

@Serializable
data object Information : Route