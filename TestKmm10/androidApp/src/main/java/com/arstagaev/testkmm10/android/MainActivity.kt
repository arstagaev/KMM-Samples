package com.arstagaev.testkmm10.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.navigator.Navigator
import com.arstagaev.testkmm10.android.component.CustomTopAppBar
import com.arstagaev.testkmm10.android.component.Screen
import com.arstagaev.testkmm10.android.detail.DetailScreen
import com.arstagaev.testkmm10.android.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
            Navigator(screen = MainScreen)
//            val scaffoldState = rememberScaffoldState()
//            val navController = rememberNavController()
//            val backStack by navController.currentBackStackEntryAsState()
//            val title = when (backStack?.destination?.route) {
//                Screen.Main.route -> "Anime Characters"
//                Screen.Detail.route -> "Anime Details"
//                else -> ""
//            }
//            Scaffold(
//                scaffoldState = scaffoldState,
//                topBar = {
//                    CustomTopAppBar(
//                        isNavVisible = title == "Anime Details",
//                        onBack = { navController.popBackStack() },
//                        title = title
//                    )
//                }
//            ) { padding ->
//                NavHost(
//                    navController = navController,
//                    startDestination = Screen.Main.route,
//                    modifier = Modifier.padding(padding)
//                ) {
//                    composable(route = Screen.Main.route) {
//                        MainScreen(navHostController = navController)
//                    }
//                    composable(route = Screen.Detail.route) {
//                        val id = it.arguments?.getString("id") ?: "45627"
//                        DetailScreen(id = id.toInt())
//                    }
//                }
//            }
        }
    }
}


