package com.sopt.at.uber.core.designsystem.ui.theme

import android.app.Activity
import androidx.activity.ComponentActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*

import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.Font
import androidx.core.view.WindowCompat
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current
}

@Composable
fun ProvideAppTheme(
    colors: AppColors,
    typography: AppTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypography provides typography,
        content = content
    )
}

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    ProvideAppTheme(
        colors = defaultAppColors,
        typography = defaultAppTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as? Activity)?.window?.let { window ->
                    WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
                }
            }
        }

        MaterialTheme(
            colorScheme = lightColorScheme(),
            typography = androidx.compose.material3.Typography(),
            content = content
        )
    }
}
