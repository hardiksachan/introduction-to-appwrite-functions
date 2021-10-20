fun main() {
    println("Hello, ${getNameFromEnv()}!")
}

fun getNameFromEnv(): String =
    System.getenv("APPWRITE_FUNCTION_DATA")