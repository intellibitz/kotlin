package refkt

import kotlin.reflect.full.memberProperties

fun main() {
    println("${refkt.name} - ${refkt.age}")
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }
    kfun.call(9)
    kprop.setter.call(1)
    println(kprop.getter.call())
}

var counter = 0
val kprop = ::counter

val refkt = Refkt("Apple", 99)
val kClass = refkt.javaClass.kotlin

class Refkt(val name: String, val age: Int)

fun foo(x: Int) = println(x)
val kfun = ::foo
//val kfun: KFunction1<Int, Unit> = ::foo

/*
Note: KFunction1, KFunction2.. et al...
These function types are synthetic compiler-generated types, and you
won’t find their declarations in the kotlin.reflect package. That means
you can use an interface for a function with any number of parameters.
The synthetic types approach reduces the size of kotlin-runtime.jar
and avoids artificial restrictions on the possible number of function type
parameters.
 */