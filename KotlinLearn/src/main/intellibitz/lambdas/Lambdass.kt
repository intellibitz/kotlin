package lambdas

import xclass.Contact

/*
Functional programming - the ability to treat functions as values.
lambdas - are small chunks of code that can be passed to other functions.
lambdas with receivers - body is executed in a different context than the surrounding code.

Lambda expressions and anonymous functions are 'function literals',
i.e. functions that are not declared, but passed immediately as an expression. Consider the following example:

max(strings, { a, b -> a.length < b.length })

Function max is a higher-order function, it takes a function value as the second argument.
This second argument is an expression that is itself a function,
i.e. a function literal, which is equivalent to the following named function:

fun compare(a: String, b: String): Boolean = a.length < b.length

Lambda expression syntax - The full syntactic form of lambda expressions is as follows:

val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

A lambda expression is always surrounded by curly braces, parameter declarations in the full syntactic form go inside
curly braces and have optional type annotations, the body goes after an -> sign. If the inferred return type of the
lambda is not Unit, the last (or possibly single) expression inside the lambda body is treated as the return value.

If we leave all the optional annotations out, what's left looks like this:

val sum = { x: Int, y: Int -> x + y }
val sum = { x: Int, y: Int -> x + y }
*/

fun main() {
    l1()
}

fun l1() {
    val contacts = listOf(Contact(1, "a@b"), Contact(2, "b@c"))
// lambda expressions - pass a block of code directly as a method parameter.
    println(contacts.maxByOrNull { it.id })
//    member reference since lambda just delegates to a method or property.. exactly same as above
    println(contacts.maxByOrNull(Contact::id))
}
