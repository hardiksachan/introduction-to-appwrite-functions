import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.json.Json
import model.ICovidStats
import model.Response

suspend fun main() {
    val country = readCountryFromEnv()

    HttpClient() {
        install(JsonFeature) {
            Json {
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
    }.use { client ->
        val response: Response = client.get("https://api.covid19api.com/summary")

        val stats: ICovidStats = response.countries.find {
            it.country.equals(country, ignoreCase = true) ||
                    it.countryCode.equals(country, ignoreCase = true) ||
                    it.slug.equals(country, ignoreCase = true)
        } ?: throw IllegalStateException()
    }

}

fun readCountryFromEnv(): String =
    System.getenv("APPWRITE_FUNCTION_DATA")