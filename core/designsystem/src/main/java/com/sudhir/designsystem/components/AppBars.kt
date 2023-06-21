package com.sudhir.designsystem.components

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sudhir.designsystem.icons.MilkifyIcons
import com.sudhir.designsystem.theme.MilkifyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MilkifyBasicTopAppBar(
    @StringRes title: Int,
    navigationIconDescription: String?,
    modifier: Modifier = Modifier,
    navigationIcon: ImageVector = MilkifyIcons.ArrowBack,
    actions: List<ActionIcon> = emptyList(),
    onNavigationIconClick: () -> Unit = {},
    onActionsIconClicked: (AppBarsActionType) -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = MilkifyTheme.colors.primary,
        titleContentColor = MilkifyTheme.colors.textPrimary,
        navigationIconContentColor = MilkifyTheme.colors.iconsTintPrimary
    ),
) {
    TopAppBar(
        title = { Text(text = stringResource(id = title)) },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = { onNavigationIconClick() }) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconDescription
                )
            }
        },
        actions = {
            AppBarActions(actions = actions, onActionsIconClicked = onActionsIconClicked)
        },
        colors = colors
    )
}

@Composable
fun AppBarActions(
    actions: List<ActionIcon>,
    modifier: Modifier = Modifier,
    onActionsIconClicked: (AppBarsActionType) -> Unit = {}
) {
    actions.forEach {
        IconButton(onClick = { onActionsIconClicked(it.actionIconType) }, modifier = modifier) {
            Icon(
                imageVector = it.actionIcon,
                contentDescription = it.contentDescription,
                tint = it.color ?: MilkifyTheme.colors.iconsTintPrimary
            )
        }
    }
}

enum class AppBarsActionType {
    Menu,
    Search
}

data class ActionIcon(
    val actionIcon: ImageVector,
    val actionIconType: AppBarsActionType,
    val contentDescription: String? = null,
    val color: Color? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MilkifyBasicTopAppBarPreview(
    modifier: Modifier = Modifier
) {
    MilkifyBasicTopAppBar(
        title = android.R.string.dialog_alert_title,
        navigationIconDescription = null
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
fun MilkifyActionsTopAppBarPreview(
    modifier: Modifier = Modifier
) {
    val actions = listOf(
        ActionIcon(
            actionIcon = MilkifyIcons.SearchIcon,
            actionIconType = AppBarsActionType.Search,
            contentDescription = null
        ),
        ActionIcon(
            actionIcon = MilkifyIcons.MenuIcon,
            actionIconType = AppBarsActionType.Menu,
            contentDescription = null
        )
    )
    MilkifyBasicTopAppBar(
        title = android.R.string.dialog_alert_title,
        navigationIconDescription = null,
        actions = actions
    )
}