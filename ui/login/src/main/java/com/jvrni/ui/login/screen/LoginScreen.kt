package com.jvrni.ui.login.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jvrni.core.components.Button
import com.jvrni.core.components.TextField
import com.jvrni.core.navigation.AppRoutes
import com.jvrni.core.theme.Colors
import com.jvrni.core.theme.Dimens
import com.jvrni.core.theme.custom.Typography
import com.jvrni.core.theme.custom.black333333
import com.jvrni.ui.home.navigation.HomeScreen
import com.jvrni.ui.login.viewmodel.LoginViewModel
import kotlin.math.roundToInt
import com.jvrni.ui.login.R

@ExperimentalPagerApi
@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onNavigate: (route: AppRoutes) -> Unit
) {
    val verticalSize = -(LocalConfiguration.current.screenHeightDp / 1.5)
    val systemUiController = rememberSystemUiController()

    if (Colors.isDark)
        systemUiController.setNavigationBarColor(black333333)

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (image, column, register) = createRefs()

        Image(
            modifier = Modifier
                .offset { IntOffset(0, verticalSize.roundToInt()) }
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = ""
        )

        Column(
            modifier = Modifier
                .offset { IntOffset(0, verticalSize.roundToInt()) }
                .constrainAs(column) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val email = remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.padding(
                    start = Dimens.large_padding,
                    end = Dimens.large_padding,
                    top = Dimens.xxxlarge_padding
                ),
                height = 60.dp,
                shape = RoundedCornerShape(200.dp),
                placeHolder = stringResource(id = R.string.placeholder_email),
                text = email
            )

            val password = remember { mutableStateOf("") }
            TextField(
                modifier = Modifier.padding(
                    horizontal = Dimens.large_padding,
                    vertical = Dimens.smedium_padding
                ),
                height = 60.dp,
                shape = RoundedCornerShape(200.dp),
                placeHolder = stringResource(id = R.string.placeholder_password),
                text = password
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = Dimens.large_padding),
                shape = RoundedCornerShape(200.dp),
                backgroundColor = Colors.primary,
                onClick = { onNavigate.invoke(HomeScreen) }
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.button_login),
                        style = Typography.ButtonLabel.xsmall,
                        color = Colors.buttonText
                    )
                }
            }

            Text(
                modifier = Modifier.padding(top = Dimens.xlarge_padding),
                text = stringResource(id = R.string.forget_password),
                style = Typography.Paragraph.xsmall,
                color = Colors.unSelectText
            )
        }

        Box(
            modifier = Modifier
                .constrainAs(register) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .background(if (Colors.isDark) black333333 else Colors.background)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = Dimens.xlarge_padding),
                text = buildAnnotatedString {
                    append(
                        stringResource(id = R.string.without_account)
                    )
                    append(
                        AnnotatedString(
                            text = " ${stringResource(id = R.string.register)} ",
                            spanStyle = SpanStyle(
                                color = Colors.primary,
                            )
                        )
                    )
                },
                style = Typography.Paragraph.xsmall,
                color = Colors.unSelectText
            )
        }
    }
}
