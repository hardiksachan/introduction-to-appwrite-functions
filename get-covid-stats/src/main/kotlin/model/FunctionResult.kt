package model

import kotlinx.serialization.Serializable

@Serializable
data class FunctionResult(
    val isGlobal: Boolean,
    val newConfirmed: Int,
    val totalConfirmed: Int,
    val newDeaths: Int,
    val totalDeaths: Int,
    val newRecovered: Int,
    val totalRecovered: Int,
)
