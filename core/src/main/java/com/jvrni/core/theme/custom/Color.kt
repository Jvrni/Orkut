package com.jvrni.core.theme.custom

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color

val purpleED2590 = Color(0xFFED2590)
val blue0094FF = Color(0xFF0094FF)
val black202020 = Color(0xFF202020)
val black000000 = Color(0xFF000000)
val black444444 = Color(0xFF444444)
val black161616 = Color(0xFF161616)
val black333333 = Color(0xFF333333)
val whiteFFFFFF = Color(0xFFFFFFFF)
val gray888888 = Color(0xFF888888)
val grayE5E5E9 = Color(0xFFE5E5E9)
val grayF7FAFC = Color(0xFFF7FAFC)

val LightThemeColors = OrkutColors(
    primary = purpleED2590,
    tertiary = black000000,
    background = whiteFFFFFF,
    backgroundInput = grayF7FAFC,
    buttonText = whiteFFFFFF,
    text = black000000,
    unSelectText = gray888888,
    border = grayE5E5E9,
    isDark = false
)

val DarkThemeColors = OrkutColors(
    primary = purpleED2590,
    tertiary = black000000,
    background = black202020,
    backgroundInput = black161616,
    buttonText = whiteFFFFFF,
    text = whiteFFFFFF,
    unSelectText = gray888888,
    border = black444444,
    isDark = true
)

@Stable
class OrkutColors(
    primary: Color,
    tertiary: Color,
    background: Color,
    backgroundInput: Color,
    buttonText: Color,
    text: Color,
    unSelectText: Color,
    border: Color,
    isDark: Boolean
) {
    var primary = mutableStateOf(primary).value
        private set
    var tertiary = mutableStateOf(tertiary).value
        private set
    var background = mutableStateOf(background).value
        private set
    var backgroundInput = mutableStateOf(backgroundInput).value
        private set
    var buttonText = mutableStateOf(buttonText).value
        private set
    var text = mutableStateOf(text).value
        private set
    var unSelectText = mutableStateOf(unSelectText).value
        private set
    var border = mutableStateOf(border).value
        private set
    var isDark = mutableStateOf(isDark).value
        private set

    fun copy(): OrkutColors = OrkutColors(
        primary = primary,
        tertiary = tertiary,
        background = background,
        backgroundInput = backgroundInput,
        buttonText = buttonText,
        text = text,
        unSelectText = unSelectText,
        border = border,
        isDark = isDark
    )

    fun update(other: OrkutColors) {
        primary = other.primary
        tertiary = other.tertiary
        background = other.background
        backgroundInput = other.backgroundInput
        buttonText = other.buttonText
        text = other.text
        unSelectText = other.unSelectText
        border = other.border
        isDark = other.isDark
    }
}