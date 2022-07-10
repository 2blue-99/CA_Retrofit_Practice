package com.example.useapi.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIImpl: API{

    private val BASE_URL = "https://api.coinpaprika.com/v1/"

    override suspend fun getCoinInfo(): List<CoinInfo> {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() // Retrofit Object Create
            .create(API::class.java).getCoinInfo()
    }

}