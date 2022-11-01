package com.anil.cryptocurrencycleanarchitecture.presentation.ui.getCoins

import com.anil.cryptocurrencycleanarchitecture.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

