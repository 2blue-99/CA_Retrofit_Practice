package com.example.useapi.data

import retrofit2.http.GET

interface API {
    @GET("coins/")
    suspend fun getCoinInfo(): List<CoinInfo>
// 코루틴 위에서 동작하므로 suspend를 안붙인다고 빌드 오류는 안나지만
    //데이터가 정상적으로 안들어와 문제 발생함.
}