package com.sudhir.designsystem.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.sudhir.designsystem.icons.MilkifyIcons
import com.sudhir.designsystem.theme.MilkifyTheme

@Composable
fun BasicIconButton(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    color: Color = MilkifyTheme.colors.iconsTintPrimary,
    onClick: () -> Unit = {}
) {
    IconButton(onClick = { onClick() }, modifier = modifier) {
        Icon(imageVector = imageVector, contentDescription = contentDescription, tint = color)
    }
}

@Composable
fun BackArrowButton(
    modifier: Modifier = Modifier,
    color: Color = MilkifyTheme.colors.iconsTintPrimary,
    onClick: () -> Unit = {}
) {
    BasicIconButton(
        imageVector = MilkifyIcons.ArrowBack,
        onClick = onClick,
        modifier = modifier,
        color = color
    )
}

@ThemePreviews
@Composable
fun SampleBackArrowButton() {
    BackArrowButton()
}