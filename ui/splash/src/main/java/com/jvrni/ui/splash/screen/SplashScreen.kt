package com.jvrni.ui.splash.screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.jvrni.core.theme.Colors
import com.jvrni.ui.splash.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun SplashScreen(
    viewModel: SplashViewModel,
    onNavigate: () -> Unit
) {
    val pulse = remember { mutableStateOf(0.8f) }
    val pulseAnimation by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = pulse.value,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    val offsetY = remember { mutableStateOf(0f) }
    val verticalSize = -(LocalConfiguration.current.screenHeightDp / 1.5)

    val animOffsetY = animateFloatAsState(
        targetValue = offsetY.value,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (pulse, image) = createRefs()


            Box(
                modifier = Modifier
                    .constrainAs(pulse) {
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                        start.linkTo(image.start)
                        end.linkTo(image.end)
                    }
                    .scale(pulseAnimation)
                    .width(200.dp)
                    .height(200.dp)
                    .clipToBounds()
                    .background(Colors.primary.copy(alpha = 0.05f), CircleShape)
            )

            Image(
                modifier = Modifier
                    .offset { IntOffset(0, animOffsetY.value.roundToInt()) }
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                painter = painterResource(id = com.jvrni.ui.login.R.drawable.ic_logo),
                contentDescription = ""
            )
        }
    }

    LaunchedEffect(true) {
        delay(4000L)

        pulse.value = 0f
        offsetY.value = verticalSize.toFloat()

        delay(1050L)
        onNavigate.invoke()
    }
}