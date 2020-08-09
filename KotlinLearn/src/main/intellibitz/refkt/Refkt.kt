package refkt

import kotlin.reflect.full.memberProperties

fun main() {
    println("${refkt.name} - ${refkt.age}")
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }
}

val refkt = Refkt("Apple", 99)
val kClass = refkt.javaClass.kotlin

class Refkt(val name: String, val age: Int)