package com.anil.cryptocurrencycleanarchitecture.domain.model

import com.google.gson.annotations.SerializedName

data class Coin(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
