package colls

import java.util.*

fun main() {
    treeM()
    itAL()
    coll()
}

val set = setOf(1, 2, 3)
val list = listOf(1, 2, 3)


// regular form
//val map = mapOf(1.to("one"), 2.to("two"), 3.to("three"))
// infix form
val map = mapOf(1 to "one", 2 to "two", 3 to "three")

val al = arrayListOf("10", "11", "1001")
val binReps = TreeMap<Char, String>()

fun coll() {
//destructuring declarations
//    val (number, name) = 1 to "one"
    println(set.maxOrNull())
    println(list.last())
    println(map.entries)
}

fun itAL() {
    for ((index, elem) in al.withIndex()) {
        println("$index : $elem")
    }
}

fun treeM() {
    for (c in 'A'..'F') {
        val bin = Integer.toBinaryString(c.toInt())
        binReps[c] = bin
    }
    for ((letter, bin) in binReps) {
        println("$letter = $bin")
    }
}