package com.example.thuctap_fe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.thuctap_fe.ui.screen.Home
import com.example.thuctap_fe.ui.screen.MainScreen
import com.example.thuctap_fe.ui.screen.PlayScreen
import com.example.thuctap_fe.ui.screen.ProfileScreen
import com.example.thuctap_fe.ui.screen.SubjectScreen
import com.example.thuctap_fe.ui.screen.WelcomeScreen

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route,
    ) {
        composable(Screen.Welcome.route) { WelcomeScreen(navController) }
        composable(Screen.Main.route) { MainScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.Subject.route) { SubjectScreen(navController) }
        composable(Screen.Home.route) { Home(navController) }
        composable(Screen.Play.route) { PlayScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.ChangePassword.route) { ChangePasswordScreen(navController) }

    }
}