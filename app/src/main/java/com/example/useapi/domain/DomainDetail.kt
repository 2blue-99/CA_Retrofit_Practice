package com.example.useapi.domain

data class DomainDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<DomainDetailTeam>
)

//fun CoinInfo.toDomainDetail(): DomainDetail = DomainDetail(
//    id,name,description,symbol,rank,isActive,tags,team
//)
