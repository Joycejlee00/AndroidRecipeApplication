package com.example.jetpackcomposeandroidrecipeapp.Navigation


import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


/*
 * Creating a composable function that holds the actual physical
 * navigation bar at the bottom of the screen.
 */
@Composable
fun NavigationScreen() {
    /*
     * Using the Navigation implementation (from the dependencies)
     * The NavController is the central API for the navigation componenet
     * this allows you to navigation between different screens
     * It keeps track of each composable that makes up each screen, for exmaple,
     * it keeps track of being on the history/recipe list screen
     *
     * To screen a controller you use the rememberNavController()
     *
     */
    val navController = rememberNavController()
    /* Scaffold is a layout which implements the material design layout structure
    * In this case, it is creating the bottom Navigation screen
    */
    Scaffold(
        /* Bottom bar represents the bottom navigation */
        bottomBar = { BottomBar(navController = navController) })
    {
        /* Calls the BottomNavGraph which routes the first component (starting Destination) */
        BottomNavGraph(navController = navController)
    }
}

/*
 * Creating a composable function that will be called within the Scaffold
 *
 */
@Composable
fun BottomBar(navController: NavController) {
    /*Define a list of all the destinations (Recipe List screen & History screen)
    Grabs the RecipeList object & HistoryList object from the BottomNavBar class
    * */
    val screens = listOf(
        BottomNavBar.RecipeList,
        BottomNavBar.HistoryList
    )

    /* Create a variable called NavBackStackEntry that
    takes [currentBackStackEntry] from the NavController component of compose
    and identify the route that is being called (the current destination)
    * */
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    /* Function that grabs the item and displays it */
    BottomNavigation{
        screens.forEach{
                screen -> AddItem(screen = screen , currentDestination = currentDestination, navController = navController)

        }
    }
}

@Composable
/* Within this add item helper function it takes in a Screen (history or recipeList), the current route destination, and the NavController */
fun RowScope.AddItem(screen : BottomNavBar, currentDestination : NavDestination?, navController : NavController){
    BottomNavigationItem(
        /*Grab the title of the screen + the icon and display on the bottom navigation bar */
        label = {
            Text(
                text = screen.title
            )},
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )},
        /* Selected is a boolean value that checks
        if the current item is selected or not
         */
        selected = currentDestination?.hierarchy?.any{
            /* If the current route is equal to the screen route */
            it.route == screen.route
        } == true,
        /*change the color of the icon/text that have not been selected */
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        /* When we click on the icon we want to navigate to the associated screen */
        onClick = {
            navController.navigate(screen.route) {
                /* Pop up the start destination, so when clicking the back button it doesnt go back
                to all the previous screens.
                So if I were to click on History, Recipe, History again.
                 When I click the back Button it should direct me back to the start Destination (Recipe List)

                launchSingleTop avoids the multiple copies of the same destination
                when re-selecting the specific item
                 */
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}
