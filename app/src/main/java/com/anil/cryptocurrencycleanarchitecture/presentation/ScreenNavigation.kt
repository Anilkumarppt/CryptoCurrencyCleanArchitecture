package com.anil.cryptocurrencycleanarchitecture.presentation

sealed class ScreenNavigation(val route:String){

    object CoinListScreen:ScreenNavigation("coins_list_screen")
    object CoinDetailScreen:ScreenNavigation("coin_detail_screen")
    
}
