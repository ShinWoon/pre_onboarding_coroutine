import kotlinx.coroutines.*
import kotlin.AssertionError
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("${Thread.currentThread().name} - runBlocking function")
            launch {
                println("${Thread.currentThread().name} - launch function")
                withContext(Dispatchers.Default) {
                    println("${Thread.currentThread().name} - withContext function")
                    delay(1000)
                    println("10 results found.")
                }
                println("${Thread.currentThread().name} - end of launch function")
            }
            println("Loading...")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async {
        getTemperature()
    }
    delay(200)
    temperature.cancel()
    "${forecast.await()} ${temperature.await()}"
}

suspend fun printForecast() {   // 정지 함수
    delay(1000) // 지연
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature(): String {
    delay(1000)
//    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}