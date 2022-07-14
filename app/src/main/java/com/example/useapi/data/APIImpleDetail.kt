package com.example.useapi.data

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIImpleDetail:APIDetail {
    private val BASE_URL = "https://api.coinpaprika.com/v1/"

//    override suspend fun get(): List<CoinInfo> {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build() // Retrofit Object Create
//            .create(API::class.java).getCoinInfo()
//    }

    override fun getCoinDetail(id: String): Single<CoinInfoDetail> {
        TODO("Not yet implemented")
    }
}