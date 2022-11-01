package com.anil.cryptocurrencycleanarchitecture.data.network.api

import com.anil.cryptocurrencycleanarchitecture.data.network.dto.CoinDetailDto
import com.anil.cryptocurrencycleanarchitecture.data.network.dto.CoinDto
import com.anil.cryptocurrencycleanarchitecture.domain.model.Coin
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPIService {

    @GET("v1/coins")
    suspend fun getCoins():List<CoinDto>
    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId:String):CoinDetailDto

}