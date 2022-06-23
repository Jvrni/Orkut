package com.jvrni.ui.profile.models

import androidx.annotation.DrawableRes
import com.jvrni.ui.profile.R

enum class Settings(@DrawableRes val icon: Int, val title: String) {
    Friends(R.drawable.ic_user, "Amigos"),
    Testimony(R.drawable.ic_testimony, "Depoimentos"),
    Gallery(R.drawable.ic_gallery, "Galeria"),
    Games(R.drawable.ic_game, "Jogos"),
    Exit(R.drawable.ic_exit, "Sair")
}