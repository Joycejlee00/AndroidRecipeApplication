package com.example.jetpackcomposeandroidrecipeapp.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

/*
A sealed class in kotlin has more control over other subcomponents
Basically a restricted class. In this case it controls the different screens (History + recipe)
It has a restricted number of options -> navigation to where to go.

This class essentially initializes the bottom navigation components
-> So the recipe list and the history
-> Object class that declares everything needed
 */

sealed class BottomNavBar(
    val route: String, /*Route = where its going*/
    val title: String, /*The title of the where its going */
    val icon: ImageVector /*Said icon for the bottom Navbar object */
) {
    /*Recipe List holds the recipe screen*/
    object RecipeList : BottomNavBar(
        route = "recipe",
        title = "RecipeList",
        icon = Icons.Default.Notifications
    )
    /*Recipe List holds the History screen*/
    object HistoryList : BottomNavBar(
        route = "history",
        title = "History",
        icon = Icons.Default.AccountCircle
    )
}