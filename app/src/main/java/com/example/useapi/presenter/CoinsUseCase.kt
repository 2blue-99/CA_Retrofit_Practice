package com.example.useapi.presenter

import com.example.useapi.domain.CoinsRepositoryImpl

class CoinsUseCase{
    suspend fun getData(): List<CoinsModel>{
        return CoinsRepositoryImpl().getCoins().map { it.toCoinsModel() }
    }
}