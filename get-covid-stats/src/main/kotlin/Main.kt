import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.utils.io.core.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import model.FunctionResult
import model.Response

suspend fun main() {
    val country = readCountryFromEnv()

    val jsonParser = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    HttpClient() {
        install(JsonFeature) {
            serializer = KotlinxSerializer(json = jsonParser)
        }
    }.use { client ->
        val response: Response = client.get("https://api.covid19api.com/summary")

        val result: FunctionResult = response.countries.find {
            it.country.equals(country, ignoreCase = true) ||
                    it.countryCode.equals(country, ignoreCase = true) ||
                    it.slug.equals(country, ignoreCase = true)
        }?.run {
            FunctionResult(
                false, newConfirmed, totalConfirmed, newDeaths,
                totalDeaths, newRecovered, totalRecovered
            )
        } ?: response.global.run {
            FunctionResult(
                true, newConfirmed, totalConfirmed, newDeaths,
                totalDeaths, newRecovered, totalRecovered
            )
        }

        println(jsonParser.encodeToString(result))
    }
}

fun readCountryFromEnv(): String =
    System.getenv("APPWRITE_FUNCTION_DATA")