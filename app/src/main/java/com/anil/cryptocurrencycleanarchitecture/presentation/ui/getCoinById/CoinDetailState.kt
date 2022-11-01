package com.anil.cryptocurrencycleanarchitecture.presentation.ui.getCoinById

import com.anil.cryptocurrencycleanarchitecture.domain.model.Coin
import com.anil.cryptocurrencycleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coin:CoinDetail?= null,
    val error:String=""
)
