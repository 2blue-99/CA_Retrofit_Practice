package com.example.useapi.domain

import com.example.useapi.data.CoinInfo

data class DomainCoins(
    val id: String,
    val name: String,
    val rank: Int,
    val isNew: Boolean,
    val isActive: Boolean,
)

fun CoinInfo.toDomainCoin(): DomainCoins = DomainCoins(
    id,name,rank,isNew,isActive
)
