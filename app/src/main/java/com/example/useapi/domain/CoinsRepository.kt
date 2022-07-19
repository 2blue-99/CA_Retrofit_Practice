package com.example.useapi.domain

interface CoinsRepository {
    suspend fun getCoins(): List<DomainCoins>
    suspend fun getDetails(id :String): DomainDetail
}