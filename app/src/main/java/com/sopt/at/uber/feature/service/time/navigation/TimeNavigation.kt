package com.sopt.at.uber.feature.service.time.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.Route
import com.sopt.at.uber.feature.service.ServiceSharedViewModel
import com.sopt.at.uber.feature.service.time.screen.TimeScreen
import kotlinx.serialization.Serializable

fun NavController.navigateToTime(navOptions: NavOptions? = null) {
    navigate(Time, navOptions)
}

fun NavGraphBuilder.timeGraph(
    modifier: Modifier = Modifier,
    sharedViewModel: ServiceSharedViewModel,
    navigateToInformation: () -> Unit,
    navigateUp: () -> Unit
) {
    composable<Time> {
        TimeScreen(
            sharedViewModel = sharedViewModel,
            navigateToInformation = navigateToInformation,
            navigateUp = navigateUp
        )
    }
}

@Serializable
data object Time : Route