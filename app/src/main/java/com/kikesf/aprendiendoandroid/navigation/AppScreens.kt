package com.kikesf.aprendiendoandroid.navigation

sealed class AppScreens(val route: String) {
    object MarvelApp: AppScreens("marvel_app")
}