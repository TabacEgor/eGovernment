package com.tabac.egovernment.model

data class VoteModel(
    val id: Long,
    val name: String,
    val type: String,
    val status: String,
    val startDate: String,
    val endDate: String = "",
    val description: String = "Composem ipsum color sit lazy, padding theme elit, sed do bouncy. ".repeat(4)
)