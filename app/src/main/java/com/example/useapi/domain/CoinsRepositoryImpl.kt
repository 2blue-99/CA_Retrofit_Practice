package com.example.useapi.domain

import com.example.useapi.data.APIImpl
import com.example.useapi.data.APIImpleDetail
import com.example.useapi.data.toDomainCoinDetail

class CoinsRepositoryImpl : CoinsRepository{
    override suspend fun getCoins(): List<DomainCoins> {
        return APIImpl().getCoinInfo().filter{ it.type == "coin" }.map{it.toDomainCoin()}
    }

    override suspend fun getDetails(id: String): DomainDetail {
        return APIImpleDetail().getCoinDetail(id).toDomainCoinDetail()
    }

}