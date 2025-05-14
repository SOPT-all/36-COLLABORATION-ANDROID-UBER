package com.sopt.at.uber.feature.home.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.MainTabRoute
import com.sopt.at.uber.feature.home.HomeScreen
import kotlinx.serialization.Serializable


fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    navigate(Home, navOptions)
}

fun NavGraphBuilder.homeGraph(
    modifier: Modifier = Modifier,
    navigateToReservation: () -> Unit
) {
    composable<Home> {
        HomeScreen(
            modifier = modifier,
            navigateToReservation = navigateToReservation
        )

    }
}

@Serializable
data object Home : MainTabRoute