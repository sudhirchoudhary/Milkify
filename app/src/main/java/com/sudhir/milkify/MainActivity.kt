package com.sudhir.milkify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sudhir.designsystem.components.ActionIcon
import com.sudhir.designsystem.components.AppBarsActionType
import com.sudhir.designsystem.components.MilkifyBasicTopAppBar
import com.sudhir.designsystem.icons.MilkifyIcons
import com.sudhir.designsystem.theme.MilkifyAppTheme
import com.sudhir.designsystem.theme.MilkifyTheme
import com.sudhir.milkify.ui.theme.MilkifyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            val systemBarColor = MilkifyTheme.colors.primary

            // Update the dark content of the system bars to match the theme
            DisposableEffect(systemUiController) {
                systemUiController.setStatusBarColor(color = systemBarColor)
                systemUiController.systemBarsDarkContentEnabled = false
                onDispose {}
            }
            MilkifyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MilkifyTheme.colors.background
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
                    Scaffold(
                        topBar = {
                            MilkifyBasicTopAppBar(
                                title = R.string.app_name,
                                navigationIconDescription = "app_name",
                                actions = actions
                            )
                        }
                    ) {
                        Box(modifier = Modifier.padding(it)) {

                        }
                    }
                }
            }
        }
    }
}