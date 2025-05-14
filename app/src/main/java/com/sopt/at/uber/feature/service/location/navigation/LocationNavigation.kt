package com.sopt.at.uber.feature.service.location.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.Route
import com.sopt.at.uber.feature.service.location.LocationScreen
import kotlinx.serialization.Serializable

fun NavController.navigateToLocation(navOptions: NavOptions? = null) {
    navigate(Location, navOptions)
}

fun NavGraphBuilder.locationGraph(
    modifier: Modifier = Modifier,
    navigateToTime: () -> Unit,
    navigateUp: () -> Unit,
) {
    composable<Location> {
        LocationScreen(
            modifier = modifier,
            navigateToTime = navigateToTime,
            navigateUp = navigateUp
        )
    }
}

@Serializable
data object Location : Route