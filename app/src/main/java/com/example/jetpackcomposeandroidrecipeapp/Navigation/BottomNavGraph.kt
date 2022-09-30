package com.example.jetpackcomposeandroidrecipeapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposeandroidrecipeapp.screens.History
import com.example.jetpackcomposeandroidrecipeapp.screens.RecipeList

/*
 * Create a bottom navigation bar that uses the Navigation Compose
 * to group each destination for each particular screen
 * startDestination is through the Navigation Compose -> where the screen will start
 * each composable has a specific route it goes to and calls the function from the SCREENS directory
 *
 * Essentially this class declares each screens that will then be navigated to
 */

@Composable
fun BottomNavGraph(navController: NavHostController) {
    /* NavHost is associated with the Navigation compose -> its a composable that is linked to the navController */
    NavHost(
        navController = navController,
        /* Start destination is the starting destination when the application opens
        * In our case the start destination would be the recipeList screen*/
        startDestination = BottomNavBar.RecipeList.route
    ) {
        /* Calls the route which was declared in the BottomNavBar class
        First composable which is the recipeList that is called from the [screens] directory */
        composable(route = BottomNavBar.RecipeList.route) {
            RecipeList()
        }
        /* Calls the route which was declared in the BottomNavBar class
        First composable which is the History that is called from the [screens] directory */
        composable(route = BottomNavBar.HistoryList.route) {
            History()
        }
    }
}