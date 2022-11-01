package com.anil.cryptocurrencycleanarchitecture.domain.usecase.get_coin

import com.anil.cryptocurrencycleanarchitecture.common.Resource
import com.anil.cryptocurrencycleanarchitecture.data.network.dto.toCoin
import com.anil.cryptocurrencycleanarchitecture.data.network.dto.toCoinDetail
import com.anil.cryptocurrencycleanarchitecture.domain.model.Coin
import com.anil.cryptocurrencycleanarchitecture.domain.model.CoinDetail
import com.anil.cryptocurrencycleanarchitecture.domain.reposiotory.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    operator fun invoke( coinId:String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.LOADING<CoinDetail>())
            val coins = coinRepository.getCoinById(coinId = coinId).toCoinDetail()
            emit(Resource.SUCCESS<CoinDetail>(coins))
        } catch(e: HttpException) {
            emit(Resource.ERROR<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.ERROR<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }

    }


}