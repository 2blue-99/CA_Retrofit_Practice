package com.example.useapi.domain

import com.example.useapi.data.APIImpl

class CoinsRepositoryImpl : CoinsRepository{
    override suspend fun getCoins(): List<DomainCoins> {
        return APIImpl().getCoinInfo().filter{ it.type == "coin" }.map{it.toDomainCoin()}
    }
}