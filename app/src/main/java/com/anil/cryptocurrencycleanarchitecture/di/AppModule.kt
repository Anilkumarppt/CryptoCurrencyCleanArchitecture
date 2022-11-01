package com.anil.cryptocurrencycleanarchitecture.di

import com.anil.cryptocurrencycleanarchitecture.common.Constants
import com.anil.cryptocurrencycleanarchitecture.common.Constants.BASE_URL
import com.anil.cryptocurrencycleanarchitecture.data.network.api.CoinPaprikaAPIService
import com.anil.cryptocurrencycleanarchitecture.data.repository.CoinRepositoryImpl
import com.anil.cryptocurrencycleanarchitecture.domain.reposiotory.CoinRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPIService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPIService): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}