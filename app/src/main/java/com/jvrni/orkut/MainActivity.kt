package com.jvrni.orkut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jvrni.core.theme.Colors
import com.jvrni.core.theme.OrkutTheme
import com.jvrni.orkut.navigation.Navigator
import com.jvrni.orkut.navigation.RouterImpl
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrkutTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Colors.background
                ) {
                    Navigator(RouterImpl(rememberAnimatedNavController()))
                }
            }
        }
    }
}