package funcs

fun main() {
    fun1()
    funL()
    funE()
    funRE()
    println(2 times "Hi")
}

private fun funRE() {
//    split takes regex
    println("12.345-6.A".split("[.\\-]".toRegex()))
//    split takes string delimiters
    println("12.345-6.A".split("-", "."))
//    split takes char delimiters
    println("12.345-6.A".split('-', '.'))
}

val sb = StringBuilder("Kotlin?")
private fun funE() {
    println("kotlin".lastChar())
    println("kotlin".lastC)

    sb.lastChar = '!'
    println(sb)
}

//infix functions
infix fun Int.times(str: String) = str.repeat(this)

//extension functions
fun String.lastChar(): Char = get(length - 1)

//extension properties
val String.lastC: Char
    get() = get(length - 1)

//extension properties
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value) {
        this.setCharAt(length - 1, value)
    }


val list = listOf(1, 2, 3)
val list2 = listOf("one", "two", "three")
private fun funL() {
    println(list.joinToString(sep = "; ", prefix = "(", postfix = ")"))
    println(list.joinToString())
    println(list2.join(prefix = "# "))
    println(list2.join())
}

//extension functions
fun <T> Collection<T>.joinToString(sep: String = ", ", prefix: String = "", postfix: String = ""): String {
    val res = StringBuilder(prefix)
    for ((i, e) in withIndex()) {
        if (i > 0) res.append(sep)
        res.append(e)
    }
    res.append(postfix)
    return res.toString()
}

//extension functions
fun Collection<String>.join(sep: String = ", ", prefix: String = "", postfix: String = "") =
    joinToString(sep, prefix, postfix)

//    expression bodies in function
fun multiply(x: Int, y: Int) = x * y

fun printMessage(message: String) {
    println(message)
}

// returning functions
fun square(x: Int): Int {
    return x * x
}

val func = operation()
fun operation(): (Int) -> Int {
    return ::square
}

val sum = calc(4, 5, ::sumf)

// higher order functions
fun sumf(x: Int, y: Int): Int {
    return x + y
}

val mul = calc(4, 5) { a, b -> a * b }
fun calc(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

private fun fun1() {
    printMessage("Hello World\n")
    println(multiply(256, 256))
    println("sum: $sum, mul: $mul")
    println(func(2))
    log("one", "two", "three")
}

//    normal block bodies function
fun printAll(vararg messages: String) {
    for (m in messages) println(m)
}

fun log(vararg entries: String) {
    printAll(*entries)
}

