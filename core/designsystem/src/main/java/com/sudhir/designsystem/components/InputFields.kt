package com.sudhir.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sudhir.designsystem.theme.MilkifyTheme

@Composable
fun MilkifyInputField(
    hint: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isError: Boolean = true,
    errorMessage: String = "Name can't be empty",
    enabled: Boolean = true,
    colors: TextFieldColors = defaultOutlinedTextFieldColors(),
    onTextChanged: (String) -> Unit = {}
) {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        placeholder = { Text(text = hint) },
        enabled = enabled,
        onValueChange = {
            text = it
            onTextChanged(it)
        },
        label = {
            val labelText = if(!isError) {
                hint
            } else {
                errorMessage.ifEmpty { hint }
            }
            Text(text = labelText)
        },
        isError = isError,
        colors = colors,
        modifier = modifier
    )
}

@Composable
fun defaultOutlinedTextFieldColors() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = MilkifyTheme.colors.textSecondary,
    unfocusedTextColor = MilkifyTheme.colors.textSecondary,
    disabledTextColor = MilkifyTheme.colors.textSecondary,
    focusedBorderColor = MilkifyTheme.colors.primary,
    focusedLabelColor = MilkifyTheme.colors.primary
)

@Preview
@Composable
fun BasicPreview(
    modifier: Modifier = Modifier
) {
    MilkifyInputField(hint = "Name")
}

@Preview
@Composable
fun ErrorPreview() {
    MilkifyInputField(
        hint = "Name",
        isError = true,
        errorMessage = "Name can't be empty"
    )
}