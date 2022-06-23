package com.jvrni.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jvrni.core.R
import com.jvrni.core.theme.Colors
import com.jvrni.core.theme.Dimens
import com.jvrni.core.theme.custom.Typography

@Composable
fun Testimony(
    entity: TestimonyEntity,
    modifier: Modifier,
    isShowingDots: Boolean
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(40.dp),
        border = BorderStroke(1.dp, Colors.border)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = Dimens.large_padding,
                    end = Dimens.large_padding,
                    top = Dimens.medium_padding,
                    bottom = Dimens.large_padding
                )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp)
                        .border(
                            width = 0.dp,
                            color = Color.Transparent,
                            shape = CircleShape
                        ),
                    painter = painterResource(entity.image),
                    contentDescription = ""
                )

                Text(
                    modifier = Modifier.padding(Dimens.small_padding),
                    text = entity.name,
                    style = Typography.Label.xxsmall
                )

                if (isShowingDots)
                    IconButton(
                        onClick = { }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.ic_dots),
                            contentDescription = ""
                        )
                    }
            }

            Text(
                modifier = Modifier.padding(top = Dimens.small_padding),
                text = entity.description,
                style = Typography.Label.xxsmall
            )
        }
    }
}

data class TestimonyEntity(
    val image: Int,
    val name: String,
    val description: String
)