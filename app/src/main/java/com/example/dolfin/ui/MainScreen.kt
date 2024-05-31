package com.example.dolfin.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dolfin.R
import com.example.dolfin.ui.components.BottomNavigationBar
import com.example.dolfin.model.BottomNavItem
import com.example.dolfin.ui.screens.HomeScreen
import com.example.dolfin.ui.screens.QuizScreen
import com.example.dolfin.ui.screens.NewsplashScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavItem("Home", ImageVector.vectorResource(id = R.drawable.ic_home_black_24dp)),
        BottomNavItem("Quiz", ImageVector.vectorResource(id = R.drawable.ic_fact_check_24dp)),
        BottomNavItem("Newsplash", ImageVector.vectorResource(id = R.drawable.ic_newspaper_24dp))
    )
    val selectedItem = remember { mutableStateOf(items[0]) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = items,
                selectedItem = selectedItem.value,
                onItemSelected = {
                    selectedItem.value = it
                    navController.navigate(it.label)
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = "Home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("Home") { HomeScreen() }
            composable("Quiz") { QuizScreen() }
            composable("Newsplash") { NewsplashScreen() }
        }
    }
}