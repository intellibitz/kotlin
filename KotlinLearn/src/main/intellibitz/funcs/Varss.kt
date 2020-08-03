package funcs

import xclass.Contact
import xclass.Customer
import xclass.MutableStack
import java.time.LocalDate

fun main() {
    println("$e, $s, $a, $b")
    describeString("hello")
    funC()
    funS()
    funM()
    (0..10).forEach { print(it) }
    println(now.plusWeeks(1) in vac)
    println("$now : $vac")
}

val now: LocalDate = LocalDate.now()
val vac = now..now.plusDays(10)


// Inferred types
const val a = 2
const val s: String = "hi"
const val b = "hello"
var e: Int = 0

// Null Safetly
var notNull: String = "some"
var canNull: String? = null

val customer = Customer()
val contact = Contact(1, "abc.com")
private fun funC() {
    println(customer)
    contact.email = "xyz.com"
    println(contact.id)
}

var stack = MutableStack(1, 2, 3)
private fun funS() {
    stack.push(4)
    stack.push(5)
    stack.pop()
    stack.isEmpty()
    stack.peek()
    println(stack.toString())
    stack = mutableStackOf(5, 6, 7)
    println(stack.toString())
}

private fun funM() {
    // val is immutable, but the object it points to can be altered
// declares an immutable reference
    val mutableContainer = arrayListOf("mutable")
// mutate the object pointed to by the reference
    mutableContainer.add("container")
}


fun describeString(maybeString: String?): String? {
    return if (maybeString != null && maybeString.isNotEmpty()) {
        notNull
    } else {
        canNull
    }
}

// generic function
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

