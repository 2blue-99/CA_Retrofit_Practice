package com.example.useapi.presenter

import com.example.useapi.domain.DomainCoins
import com.example.useapi.domain.DomainDetail
import com.example.useapi.domain.DomainDetailTeam

data class CoinsDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<DomainDetailTeam>
)

fun DomainDetail.toCoinsDetail(): CoinsDetail = CoinsDetail(
    coinId, name, description, symbol, rank, isActive, tags, team
)
