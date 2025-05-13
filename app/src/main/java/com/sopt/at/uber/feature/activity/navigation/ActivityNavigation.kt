package com.sopt.at.uber.feature.activity.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.sopt.at.uber.core.navigation.MainTabRoute
import com.sopt.at.uber.feature.activity.ActivityScreen
import kotlinx.serialization.Serializable

fun NavController.navigateToActivity(navOptions: NavOptions? = null) {
    navigate(Activity, navOptions)
}

fun NavGraphBuilder.activityGraph() {
    composable<Activity> {
        ActivityScreen()
    }
}

@Serializable
data object Activity : MainTabRoute