package com.anil.cryptocurrencycleanarchitecture.presentation.ui.getCoinById

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anil.cryptocurrencycleanarchitecture.common.Constants
import com.anil.cryptocurrencycleanarchitecture.common.Resource
import com.anil.cryptocurrencycleanarchitecture.domain.usecase.get_coin.GetCoinByIdUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinsByIdUseCase: GetCoinByIdUseCase,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {
    private val _state= mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {coinId->
            getCoinById(coinId = coinId)
        }
    }
    private fun getCoinById(coinId:String){
        getCoinsByIdUseCase(coinId = coinId).onEach { result->
            when(result){
                is Resource.SUCCESS-> _state.value= CoinDetailState( coin =result.data)
                is Resource.ERROR -> _state.value= CoinDetailState(error = result.message?:"An UnExpected error occurred")
                is Resource.LOADING -> _state.value= CoinDetailState(isLoading = true)
            }

        }.launchIn(viewModelScope)
    }
}