package com.jvrni.core.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jvrni.core.theme.Colors
import com.jvrni.core.theme.Dimens
import com.jvrni.core.theme.custom.Typography
import com.jvrni.core.theme.custom.blue0094FF

@Composable
fun Story(
    storyEntity: StoryEntity,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = Dimens.small_padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(65.dp)
                .border(
                    border = BorderStroke(
                        width = 2.dp,
                        brush = Brush.linearGradient(listOf(Colors.primary, blue0094FF))
                    ),
                    shape = CircleShape
                )
                .padding(Dimens.small_corner_radius),
            painter = painterResource(id = storyEntity.image),
            contentDescription = ""
        )

        Text(
            modifier = Modifier.padding(top = Dimens.small_padding),
            text = storyEntity.name,
            style = Typography.Label.xxsmall
        )
    }
}

data class StoryEntity(
    @DrawableRes val image: Int,
    val name: String
)