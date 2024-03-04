package com.example.helloskillboxcompose2

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.helloskillboxcompose2.ui.theme.SecondScreen

enum class ScreenName(@StringRes val value: Int) {
    FirstScreen(R.string.first_screen),
    SecondScreen(R.string.second_screen)
}

@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    Scaffold() { paddingValues ->
        NavHost(navController = navController, startDestination = ScreenName.FirstScreen.name, modifier = Modifier.padding(paddingValues)) {
            composable(route = ScreenName.FirstScreen.name) {
                FirstScreen(text = "Hello, Skillbox", onClick = {
                    navController.navigate(ScreenName.SecondScreen.name,
                        args = bundleOf("TEXT" to it)
                    )
                })
            }
            composable(route = ScreenName.SecondScreen.name) {
                SecondScreen(it.arguments?.getString("TEXT").orEmpty())
            }
            
        }
    }
}

fun NavHostController.navigate(route: String, args: Bundle, navOptions: NavOptions? = null, navigationExtras: Navigator.Extras? = null) {
    val nodeId = graph.findNode(route = route)?.id
    if (nodeId != null) {
        navigate(nodeId, args, navOptions, navigationExtras)
    }
}