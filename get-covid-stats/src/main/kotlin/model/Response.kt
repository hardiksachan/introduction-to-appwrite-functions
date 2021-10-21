package model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class Response(
    @SerialName("Global") val global : GlobalStats,
    @SerialName("Countries") val countries : List<CountryStats>,
)