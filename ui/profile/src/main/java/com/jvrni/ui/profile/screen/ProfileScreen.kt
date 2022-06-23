package com.jvrni.ui.profile.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jvrni.core.theme.custom.Typography
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jvrni.ui.profile.viewmodel.ProfileViewModel
import com.jvrni.core.navigation.AppRoutes
import com.jvrni.core.theme.Colors
import com.jvrni.core.theme.Dimens
import com.jvrni.core.theme.custom.blue0094FF
import com.jvrni.core.R
import com.jvrni.core.base.ViewState
import com.jvrni.domain.users.models.User
import com.jvrni.ui.profile.models.Settings
import com.jvrni.ui.profile.viewmodel.ProfileState

@ExperimentalPagerApi
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onBack: () -> Unit,
    onNavigate: (route: AppRoutes) -> Unit
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = Dimens.medium_padding, horizontal = Dimens.medium_padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        IconButton(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = Dimens.xlarge_padding),
            onClick = { onBack.invoke() }
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = ""
            )
        }

        state?.let { state ->
            when (state) {
                is ProfileState -> Profile(state.user)
                is ViewState.Loading -> {
                    // TODO loading
                }
            }
        }
    }
}

@Composable
private fun Profile(user: User) {
    Image(
        modifier = Modifier
            .size(140.dp)
            .border(
                border = BorderStroke(
                    width = 2.dp,
                    brush = Brush.linearGradient(listOf(Colors.primary, blue0094FF))
                ),
                shape = CircleShape
            )
            .padding(Dimens.small_corner_radius),
        painter = painterResource(id = user.image),
        contentDescription = ""
    )

    Text(
        modifier = Modifier.padding(top = Dimens.medium_padding),
        text = user.name,
        style = Typography.Heading.xsmall,
        color = Colors.text
    )

    Text(
        modifier = Modifier.padding(top = Dimens.xsmall_padding),
        text = user.genre,
        style = Typography.Paragraph.xsmall,
        color = Colors.unSelectText
    )

    Text(
        modifier = Modifier.padding(top = Dimens.xsmall_padding),
        text = user.country,
        style = Typography.Paragraph.xsmall,
        color = Colors.unSelectText
    )

    Divider(
        modifier = Modifier.padding(Dimens.xlarge_padding),
        color = Colors.border
    )

    Settings.values().forEach { item ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .padding(vertical = Dimens.medium_padding, horizontal = Dimens.xlarge_padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = item.icon),
                contentDescription = ""
            )

            Text(
                modifier = Modifier.padding(start = Dimens.large_padding),
                text = item.title,
                style = Typography.Paragraph.small,
                color = Colors.text
            )
        }
    }
}
