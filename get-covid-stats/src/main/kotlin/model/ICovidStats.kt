package model

interface ICovidStats {
    val newConfirmed: Int
    val totalConfirmed: Int
    val newDeaths: Int
    val totalDeaths: Int
    val newRecovered: Int
    val totalRecovered: Int
}