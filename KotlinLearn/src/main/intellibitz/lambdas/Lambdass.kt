package lambdas

import xclass.Contact

/*
Functional programming - the ability to treat functions as values.
lambdas - are small chunks of code that can be passed to other functions.
lambdas with receivers - body is executed in a different context than the surrounding code.

a higher-order function is a function that takes another function as an argument or returns one.

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
    ft()
    fCA()
    fFoo()
}

private fun fFoo() {
    foo {}
    foo { println("lambda foo as param") }
//    uses anonymous function with expression body as param in place of a lambda expression
    foo(fun() = println("anonymous function foo with expression body as param"))
// anonymous functions are another syntactic form of lambda expressions
    foo(fun() { println("anonymous function foo with block body as param") })
}

// nullable function type as param
fun foo(callback: (() -> Unit)?) {
    callback?.invoke()
//    invokes the FunctionN interface defined by kotlin.. same as below
/*
    if (callback != null) {
        callback()
    }
*/
}

// calling functions passed as arguments
// declares a parameter of function type
fun twoAndThree(operation: (Int, Int) -> Int) {
//    calls the parameter of the function type
    val result = operation(2, 3)
    println("The result is $result")
}

private fun fCA() {
//    param types can be inferred from function param
    twoAndThree { a, b -> a + b }
//    storing the lambda as function type, params type must be explicitly specified
    val xTimesY = { x: Int, y: Int -> x * y }
    twoAndThree(xTimesY)
    println(xTimesY(3, 2))
}

//  function types
//  ( ) -> Unit
fun ft() {
//    implicit, short form
//    val action = { println(42) }
//    explicit declaration
    val action: () -> Unit = { println(42) }
    println(action)
//    function type with return null
    val canReturnNull: () -> Int? = { null }
    println(canReturnNull)
//    function type itself can be nullable.. NOTE the brackets
    val funOrNull: (() -> Int)? = null
    println(funOrNull)
}

fun l1() {
    val contacts = listOf(Contact(1, "a@b"), Contact(2, "b@c"))
// lambda expressions - pass a block of code directly as a method parameter.
    println(contacts.maxByOrNull { it.id })
//    member reference since lambda just delegates to a method or property.. exactly same as above
    println(contacts.maxByOrNull(Contact::id))
}
