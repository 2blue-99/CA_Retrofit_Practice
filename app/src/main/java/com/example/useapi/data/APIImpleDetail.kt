package com.example.useapi.data

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIImpleDetail: APIDetail{
    private val BASE_URL = "https://api.coinpaprika.com/v1/"

    override suspend fun getCoinDetail(id: String): CoinInfoDetail {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() // Retrofit Object Create
            .create(APIDetail::class.java).getCoinDetail(id)

    }
}