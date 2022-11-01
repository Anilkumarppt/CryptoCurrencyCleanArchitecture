package com.anil.cryptocurrencycleanarchitecture.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anil.cryptocurrencycleanarchitecture.common.Constants
import com.anil.cryptocurrencycleanarchitecture.presentation.ui.getCoinById.CoinDetailScreen
import com.anil.cryptocurrencycleanarchitecture.presentation.ui.getCoins.components.CoinSListScreen

@Composable
fun CoinAppNavigation(){

    val navController:NavHostController= rememberNavController()

    NavHost(navController =navController , startDestination = ScreenNavigation.CoinListScreen.route){
        composable(ScreenNavigation.CoinListScreen.route){
            CoinSListScreen(navController = navController)
        }
        composable(ScreenNavigation.CoinDetailScreen.route+"/{coinId}"){
            CoinDetailScreen()
        }
    }

}