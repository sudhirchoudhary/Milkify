package com.sudhir.authentication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sudhir.designsystem.components.MilkifyInputField
import com.sudhir.designsystem.components.TransparentTopAppBar
import com.sudhir.designsystem.theme.MilkifyTheme
import com.sudhir.utils.logd

@Composable
fun AuthenticationScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {  },
        containerColor = MilkifyTheme.colors.background
    ) {
        Box(modifier = Modifier.padding(it)) {
            TransparentTopAppBar()
            Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
                MilkifyInputField("Name") {
                    logd(it)
                }

                MilkifyInputField("Name") {
                    logd(it)
                }
            }
        }
    }
}

