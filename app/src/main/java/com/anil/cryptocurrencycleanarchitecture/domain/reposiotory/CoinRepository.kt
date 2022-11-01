package com.anil.cryptocurrencycleanarchitecture.domain.reposiotory

import com.anil.cryptocurrencycleanarchitecture.data.network.dto.CoinDetailDto
import com.anil.cryptocurrencycleanarchitecture.data.network.dto.CoinDto
import com.anil.cryptocurrencycleanarchitecture.domain.model.Coin

/*To help the test cases for this repository */

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId:String):CoinDetailDto
}