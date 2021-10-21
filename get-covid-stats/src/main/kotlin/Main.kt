fun main() {
    println("Hello, world!")
}

fun readCountryFromEnv(): String =
    System.getenv("APPWRITE_FUNCTION_DATA")