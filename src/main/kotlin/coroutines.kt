import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() {
    val coroutinesTimeMillis = measureTimeMillis {
        runKotlinCoroutines(100_000)
    }
    println("coroutinesTimeMillis: $coroutinesTimeMillis")

    val threadsTimeMillis = measureTimeMillis {
        runJavaThreads(100_000)
    }
    println("threadsTimeMillis: $threadsTimeMillis")
}

fun runKotlinCoroutines(n: Int)= runBlocking {
    val coroutines = List(n) {
        async {
            delay(1000)
        }
    }

    coroutines.forEach {it.join() }
}

fun runJavaThreads(n: Int) {
    val threads = List(n) {
        thread {
            sleep(1000)
        }
    }

    threads.forEach {it.join()}
}
