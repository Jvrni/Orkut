package com.jvrni.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.jvrni.core.theme.Colors
import com.jvrni.core.theme.custom.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TextField(
    modifier: Modifier,
    shape: Shape,
    height: Dp = 60.dp,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = Colors.backgroundInput,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        textColor = Colors.text,
        placeholderColor = Colors.unSelectText,
        cursorColor = Colors.primary
    ),
    singleLine: Boolean = true,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    placeHolder: String,
    text: MutableState<String>
) {
    TextField(
        modifier = modifier
            .height(height)
            .border(
                border = BorderStroke(1.dp, Colors.border),
                shape = shape
            )
            .fillMaxWidth(),
        shape = shape,
        colors = colors,
        singleLine = singleLine,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        placeholder = {
            Text(
                text = placeHolder,
                style = Typography.Paragraph.xsmall
            )
        },
        value = text.value,
        onValueChange = { text.value = it }
    )
}

@Composable
fun TextField(
    modifier: Modifier,
    height: Dp = 60.dp,
    shape: Shape,
    background: Color = Colors.backgroundInput,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = background,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        textColor = Colors.text,
        placeholderColor = Colors.unSelectText,
        cursorColor = Colors.primary
    ),
    singleLine: Boolean = true,
    leadingIcon: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    placeHolder: AnnotatedString,
    text: MutableState<String>
) {
    TextField(
        modifier = modifier
            .height(height)
            .border(
                border = BorderStroke(1.dp, Colors.border),
                shape = shape
            )
            .fillMaxWidth(),
        shape = shape,
        colors = colors,
        singleLine = singleLine,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        placeholder = {
            Text(
                text = placeHolder,
                style = Typography.Paragraph.xsmall
            )
        },
        value = text.value,
        onValueChange = { text.value = it }
    )
}