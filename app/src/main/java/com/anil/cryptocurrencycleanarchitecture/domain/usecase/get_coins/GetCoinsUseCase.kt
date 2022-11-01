package com.anil.cryptocurrencycleanarchitecture.domain.usecase.get_coins

import android.util.Log
import androidx.lifecycle.LiveData

import com.anil.cryptocurrencycleanarchitecture.common.Resource
import com.anil.cryptocurrencycleanarchitecture.data.network.dto.toCoin
import com.anil.cryptocurrencycleanarchitecture.domain.model.Coin
import com.anil.cryptocurrencycleanarchitecture.domain.reposiotory.CoinRepository
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.LOADING<List<Coin>>())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.SUCCESS<List<Coin>>(coins))
        } catch(e: HttpException) {
            emit(Resource.ERROR<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.ERROR<List<Coin>>("Couldn't reach server. Check your internet connection."))
        }
    }


}
