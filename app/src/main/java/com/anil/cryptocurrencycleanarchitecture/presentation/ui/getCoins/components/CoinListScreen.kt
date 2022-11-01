package com.anil.cryptocurrencycleanarchitecture.presentation.ui.getCoins.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.anil.cryptocurrencycleanarchitecture.presentation.ScreenNavigation
import com.anil.cryptocurrencycleanarchitecture.presentation.ui.getCoins.CoinListViewModel


@Composable
fun CoinSListScreen(navController: NavController,
                    viewModel: CoinListViewModel= hiltViewModel()){

    val state=viewModel.state.value
    
    Box(modifier = Modifier.fillMaxSize()){

        LazyColumn(){
            items(state.coins) {
                CoinListItem(coin = it, onItemClick ={coin ->
                    navController.navigate(ScreenNavigation.CoinDetailScreen.route+"/${coin.id}")
                } )
            }
        }
        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(
                        Alignment.Center
                    )
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}