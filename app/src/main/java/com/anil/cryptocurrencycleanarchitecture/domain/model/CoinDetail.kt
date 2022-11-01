package com.anil.cryptocurrencycleanarchitecture.domain.model

import com.anil.cryptocurrencycleanarchitecture.data.network.dto.TeamMember
import com.google.gson.annotations.SerializedName

data class CoinDetail(
    val coinId: String,
    val name: String,
    val rank: Int,
    val description:String,
    val symbol: String,
    val isActive:Boolean,
    val tags:List<String>,
    val team:List<TeamMember>
)
