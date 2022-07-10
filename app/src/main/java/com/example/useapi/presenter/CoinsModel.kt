package com.example.useapi.presenter

import com.example.useapi.data.CoinInfo
import com.example.useapi.domain.DomainCoins

data class CoinsModel(
    val id: String,
    val name: String,
    val rank: Int,
    val isNew: Boolean,
    val isActive: Boolean,
)

fun DomainCoins.toCoinsModel(): CoinsModel = CoinsModel(
    id,name,rank,isNew,isActive
)
