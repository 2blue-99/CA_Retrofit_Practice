package com.example.useapi.data

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface APIDetail {
    @GET("/v1/coins/{coin_id}")
    fun getCoinDetail(
        @Path("coin_id")
        id: String
    ): Single<CoinInfoDetail> // 한 번의 이벤트를 발생 시킬 때는 Single 사용.
}