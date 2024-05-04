package com.kikesf.aprendiendoandroid.navigation

sealed class AppScreens(val route: String) {
    object FirstScreen: AppScreens("first_screen")
    object MarvelApp: AppScreens("marvel_app")
}