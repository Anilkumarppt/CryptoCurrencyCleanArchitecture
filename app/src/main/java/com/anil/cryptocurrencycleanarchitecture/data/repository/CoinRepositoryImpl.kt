package com.anil.cryptocurrencycleanarchitecture.data.repository

import com.anil.cryptocurrencycleanarchitecture.data.network.api.CoinPaprikaAPIService
import com.anil.cryptocurrencycleanarchitecture.data.network.dto.CoinDetailDto
import com.anil.cryptocurrencycleanarchitecture.data.network.dto.CoinDto
import com.anil.cryptocurrencycleanarchitecture.domain.reposiotory.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val apiService: CoinPaprikaAPIService) :CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return apiService.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return apiService.getCoinById(coinId = coinId)
    }
}