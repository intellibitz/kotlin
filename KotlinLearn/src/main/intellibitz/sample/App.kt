package sample

import misc.To
import misc.greet
import misc.print

class App {
    val kotlinLogo = """| //
.|//
.|/ \"""
    val greeting: String
        get() = "Hello world."
}

fun main(args: Array<String>) {
    println("size: " + args.size)
    greet {
        To.place
    }.print()
    val app = App()
    println(app.kotlinLogo.trimMargin("."))
    println(app.greeting)
}


