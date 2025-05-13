package com.sopt.at.uber.feature.service.history.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.Route
import com.sopt.at.uber.feature.service.history.HistoryScreen
import kotlinx.serialization.Serializable


fun NavController.navigateToHistory(navOptions: NavOptions? = null) {
    navigate(History, navOptions)
}

fun NavGraphBuilder.historyGraph(
    modifier: Modifier = Modifier,
    navigateUp: () -> Unit
) {
    composable<History> {
        HistoryScreen(
            modifier = modifier,
            navigateUp = navigateUp
        )
    }
}

@Serializable
data object History : Route