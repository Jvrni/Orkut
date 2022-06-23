package com.jvrni.core.theme.custom

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jvrni.core.R
import com.jvrni.core.theme.custom.Typography.Font.Montserrat

sealed class Typography {
    object Font {
        val Montserrat = FontFamily(
            Font(R.font.montserrat_light, FontWeight.W300),
            Font(R.font.montserrat_regular, FontWeight.W400),
            Font(R.font.montserrat_medium, FontWeight.W500),
            Font(R.font.montserrat_semibold, FontWeight.W600),
            Font(R.font.montserrat_bold, FontWeight.W700)
        )
    }

    object Display {
        val large = TextStyle(fontSize = 104.sp, lineHeight = 128.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val medium = TextStyle(fontSize = 56.sp, lineHeight = 72.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val small = TextStyle(fontSize = 48.sp, lineHeight = 60.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val xsmall = TextStyle(fontSize = 40.sp, lineHeight = 48.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
    }

    object Heading {
        val xxlarge = TextStyle(fontSize = 44.sp, lineHeight = 56.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val xlarge = TextStyle(fontSize = 40.sp, lineHeight = 48.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val large = TextStyle(fontSize = 35.sp, lineHeight = 44.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val medium = TextStyle(fontSize = 31.sp, lineHeight = 40.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val small = TextStyle(fontSize = 26.sp, lineHeight = 32.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val xsmall = TextStyle(fontSize = 22.sp, lineHeight = 28.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
    }

    object Label {
        val large = TextStyle(fontSize = 20.sp, lineHeight = 24.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val medium = TextStyle(fontSize = 18.sp, lineHeight = 24.sp, fontFamily = Montserrat, fontWeight = FontWeight.W500)
        val small = TextStyle(fontSize = 16.sp, lineHeight = 20.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val xsmall = TextStyle(fontSize = 13.sp, lineHeight = 16.sp, fontFamily = Montserrat, fontWeight = FontWeight.W500)
        val xxsmall = TextStyle(fontSize = 11.sp, lineHeight = 16.sp, fontFamily = Montserrat, fontWeight = FontWeight.W400)
    }

    object Paragraph {
        val large = TextStyle(fontSize = 20.sp, lineHeight = 24.sp, fontFamily = Montserrat, fontWeight = FontWeight.W400)
        val medium = TextStyle(fontSize = 18.sp, lineHeight = 24.sp, fontFamily = Montserrat, fontWeight = FontWeight.W400)
        val small = TextStyle(fontSize = 16.sp, lineHeight = 20.sp, fontFamily = Montserrat, fontWeight = FontWeight.W400)
        val xsmall = TextStyle(fontSize = 13.sp, lineHeight = 16.sp, fontFamily = Montserrat, fontWeight = FontWeight.W400)
    }

    object ButtonLabel {
        val larger = TextStyle(fontSize = 18.sp, lineHeight = 24.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val medium = TextStyle(fontSize = 16.sp, lineHeight = 20.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val small = TextStyle(fontSize = 14.sp, lineHeight = 16.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
        val xsmall = TextStyle(fontSize = 12.sp, lineHeight = 16.sp, fontFamily = Montserrat, fontWeight = FontWeight.W600)
    }
}
