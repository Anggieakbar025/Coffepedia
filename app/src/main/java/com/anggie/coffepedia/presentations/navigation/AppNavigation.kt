package com.anggie.coffepedia.presentations.navigation

enum class AppScreen {
    WELCOME,
    DASHBOARD,
}

sealed class NavigationItem(val route: String) {
    object Welcome: NavigationItem(AppScreen.WELCOME.name)
    object Dashboard: NavigationItem(AppScreen.DASHBOARD.name)
    object Detail: NavigationItem("detail/{id}") {
        fun createRoute(id: Int): String = "detail/$id"
    }
}