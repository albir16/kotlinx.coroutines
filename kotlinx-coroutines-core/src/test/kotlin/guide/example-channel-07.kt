// This file was automatically generated from coroutines-guide.md by Knit tool. Do not edit.
package guide.channel.example07

import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.channels.*

suspend fun sendString(channel: SendChannel<String>, s: String, time: Long) {
    while (true) {
        delay(time)
        channel.send(s)
    }
}

fun main(args: Array<String>) = runBlocking<Unit> {
    val channel = Channel<String>()
    launch(context) { sendString(channel, "foo", 200L) }
    launch(context) { sendString(channel, "BAR!", 500L) }
    repeat(6) { // receive first six
        println(channel.receive())
    }
}