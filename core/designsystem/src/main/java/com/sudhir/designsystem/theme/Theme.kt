package com.sudhir.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color



fun lightColors(
    primary: Color = colorLightPrimary,
    textPrimary: Color = colorLightTextPrimary,
    secondary: Color = colorLightSecondary,
    textSecondary: Color = colorLightTextSecondary,
    background: Color = colorLightBackground,
    iconsTintPrimary: Color = colorLightIconsTintPrimary,
    error: Color = colorLightError,
): MilkifyAppColors = MilkifyAppColors(
    primary = primary,
    textPrimary = textPrimary,
    background = background,
    error = error,
    secondary = secondary,
    textSecondary = textSecondary,
    iconsTintPrimary = iconsTintPrimary,
    disabledTextColor = colorLightDisabledTextColor,
    isLight = true
)
fun localColors(isSystemInDark: Boolean = false) = staticCompositionLocalOf {
    /*if(isSystemInDark) {
        darkColors()
    } else
        lightColors()*/
    //we will only focus on light theme right now
    lightColors()
}

fun darkColors(
    primary: Color = colorDarkPrimary,
    textPrimary: Color = colorDarkTextPrimary,
    secondary: Color = colorDarkSecondary,
    textSecondary: Color = colorDarkTextSecondary,
    background: Color = colorDarkBackground,
    iconsTintPrimary: Color = colorDarkIconsTintPrimary,
    error: Color = colorDarkError,
): MilkifyAppColors = MilkifyAppColors(
    primary = primary,
    textPrimary = textPrimary,
    background = background,
    error = error,
    secondary = secondary,
    textSecondary = textSecondary,
    iconsTintPrimary = iconsTintPrimary,
    disabledTextColor = colorDarkDisabledTextColor,
    isLight = false
)

object MilkifyTheme {

    val colors: MilkifyAppColors
        @Composable
        @ReadOnlyComposable
        get() = localColors(isSystemInDarkTheme()).current

    val typography: MilkifyAppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimensions: MilkifyAppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}

class MilkifyAppColors(
    primary: Color,
    secondary: Color,
    textPrimary: Color,
    textSecondary: Color,
    iconsTintPrimary: Color,
    background: Color,
    error: Color,
    disabledTextColor: Color,
    isLight: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var error by mutableStateOf(error)
        private set
    var isLight by mutableStateOf(isLight)
        internal set
    var iconsTintPrimary by mutableStateOf(iconsTintPrimary)
        internal set
    var background by mutableStateOf(background)
        internal set
    var disabledTextColor by mutableStateOf(disabledTextColor)
        internal set

    fun copy(
        primary: Color = this.primary,
        secondary: Color = this.secondary,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.secondary,
        background: Color = this.background,
        error: Color = this.error,
        iconsTintPrimary: Color = this.iconsTintPrimary,
        disabledTextColor: Color = this.disabledTextColor,
        isLight: Boolean = this.isLight
    ): MilkifyAppColors = MilkifyAppColors(
        primary = primary,
        secondary = secondary,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        background = background,
        error = error,
        iconsTintPrimary = iconsTintPrimary,
        disabledTextColor = disabledTextColor,
        isLight = isLight
    )

    // will be explained later
    fun updateColorsFrom(other: MilkifyAppColors) {
        primary = other.primary
        textPrimary = other.textPrimary
        secondary = other.secondary
        iconsTintPrimary = other.iconsTintPrimary
        isLight = other.isLight
        error = other.error
        textSecondary = other.textSecondary
        background = other.background
    }
}

@Composable
fun MilkifyAppTheme(
    colors: MilkifyAppColors = MilkifyTheme.colors,
    typography: MilkifyAppTypography = MilkifyTheme.typography,
    dimensions: MilkifyAppDimensions = MilkifyTheme.dimensions,
    content: @Composable () -> Unit
) {
    // creating a new object for colors to not mutate the initial colors set when updating the values
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }

    CompositionLocalProvider(
        localColors(isSystemInDark = isSystemInDarkTheme()) provides rememberedColors,
        LocalDimensions provides dimensions,
        LocalTypography provides typography
    ) {
        content()
    }
}