package com.anil.cryptocurrencycleanarchitecture.data.network.dto

import com.anil.cryptocurrencycleanarchitecture.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("type")
    val type: String
)
fun CoinDto.toCoin():Coin{
    return Coin(
        id=id,
        isActive = isActive,
        isNew=isNew,
        name = name,
        rank = rank,
        symbol = symbol
    )
}