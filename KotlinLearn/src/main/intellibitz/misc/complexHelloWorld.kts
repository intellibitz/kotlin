package misc

// Inline higher-order functions
inline fun greet(s: () -> String): String = greeting andAnother s()

// Infix functions, extensions, type inference, nullable types,
// lambda expressions, labeled this, Elvis operator (?:)
infix fun String.andAnother(other: Any?) = buildString()
{
    append(this@andAnother); append(" "); append(other ?: "")
}

// Immutable types, delegated properties, lazy initialization, string templates
val greeting by lazy { val doubleEl = "ll"; "he${doubleEl}o" }

// Sealed classes, companion objects
sealed class To {
    companion object {
        const val place = "world"
    }
}

// Extensions, Unit
fun String.print() = println(this)

println ("size: " + args.size)
greet {
    To.place
}.print()

