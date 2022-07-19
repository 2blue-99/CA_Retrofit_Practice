package com.example.useapi.presenter

import com.example.useapi.domain.CoinsRepositoryImpl

class CoinsUseCase{
    suspend fun getData(): List<CoinsModel>{
        return CoinsRepositoryImpl().getCoins().map { it.toCoinsModel() }
    }

    suspend fun getDetail(id: String): CoinsDetail{
//        println("")
        return CoinsRepositoryImpl().getDetails(id).toCoinsDetail()
    }
}