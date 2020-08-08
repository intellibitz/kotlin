package genric

fun main() {
    println(listOf(1, 2, 3).penultimate)
    println(oneHalf(33))
//    println(oneHalf("12")
    println(ensureTrailingPeriod(hello))
    println(hello)
    println(ip.process(2))
    println(sp.process(null))
    println(isA<Int>(2))
}

inline fun <reified T> isA(value: Any) = value is T

val ip: Processor<Int> = Processor()
val sp = Processor<String?>()

class Processor<T> {
    fun process(value: T) {
        value?.hashCode()
    }
}

//generic extension property
val <T> List<T>.penultimate: T
    get() = this[size - 2]
//NOTE: generic non extension property, generic regular properties are not supported
//val <T> x: T = TODO()

fun <T : Number> oneHalf(value: T): Double {
//    invokes methods defined in upper bound type (Number in this case)
    return value.toDouble() / 2
}

val hello = StringBuilder("Hello World")

// specifies multiple constraints on type parameter (Note: CharSequence, Appendable)
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith(".")) seq.append(".")
}