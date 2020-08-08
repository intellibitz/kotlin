package genric

fun main() {
    println(listOf(1, 2, 3).penultimate)
}

val <T> List<T>.penultimate: T
    get() = this[size - 2]
