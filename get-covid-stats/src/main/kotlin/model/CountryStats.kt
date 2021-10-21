package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryStats(
    @SerialName("Country") val country: String,
    @SerialName("CountryCode") val countryCode: String,
    @SerialName("Slug") val slug: String,
    @SerialName("NewConfirmed") override val newConfirmed: Int,
    @SerialName("TotalConfirmed") override val totalConfirmed: Int,
    @SerialName("NewDeaths") override val newDeaths: Int,
    @SerialName("TotalDeaths") override val totalDeaths: Int,
    @SerialName("NewRecovered") override val newRecovered: Int,
    @SerialName("TotalRecovered") override val totalRecovered: Int,
) : ICovidStats

