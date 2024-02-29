import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {   // 여러 태스크를 한 번에 처리할 수 있는 이벤트 루프를 실행
            println("Weather forecast")
            printForecast()
            printTemperature()
        }
    }
    println("Execution time: ${time/1000.0} seconds")
}

suspend fun printForecast() {   // 정지 함수
    delay(1000) // 지연
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}