package xclass

import java.io.File

fun main() {
    funU()
    funO()
    funE()

    rentPrice(10, 2, 1)
    BigBen.getBongs(2)

    println(CaseInsensitiveFileComparator.compare(File("/Users"), File("/users")))
}

val user = User("A", 1)
val user2 = User("B", 2)
val user3 = User("C", 3)
val alluser = listOf(user3, user, user2)
private fun funU() {
    println(alluser.sortedWith(User.NameComparator))
    println(user.hashCode() + user2.hashCode() + user3.hashCode())
}

//Note: if 'data' class is defined, then equals, hascode, tostring, copy and other are automatically generated !!
data class User(val name: String, val id: Int) {
    //    object defines a class and a variable of that class in a single statement
    object NameComparator : Comparator<User> {
        override fun compare(p1: User, p2: User): Int =
            p1.name.compareTo(p2.name)
    }
}

//    object defines a class and a variable of that class in a single statement
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int = file1.path.compareTo(file2.path, ignoreCase = true)
}

class BigBen {
    //    object defines a class and a variable of that class in a single statement
// companion object lets containing classes access to members and methods as well extension functions
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            for (i in 1..nTimes) {
                println("BONG ")
            }
        }
    }
}

val red = Color.RED
val blue = Color.BLUE
private fun funE() {
    println(red.mix(red, blue))
    println(red.containsRed())
    println(Color.BLUE.containsRed())
    println(red.getColor(red))
}

val order = Order(
    listOf(
        Item("Bread", 25.0F),
        Item("Wine", 29.0F), Item("Water", 12.0F)
    )
)

private fun funO() {
    println("Max priced item name: ${order.maxPricedItemName()}")                     // 4
    println("Max priced item value: ${order.maxPricedItemValue()}")
    println("Items: ${order.orderCommaDelimitedNames}")
}

// object classes
fun rentPrice(a: Int, b: Int, c: Int) {
//    object expression
    val dayRates = object {
        var std: Int = 30 * a
        var s2: Int = 50 * b
        var s3: Int = 100 * c
    }
    val tot = dayRates.std + dayRates.s2 + dayRates.s3
    print("Price: $tot")
}


// extension function and properties
val Order.orderCommaDelimitedNames: String
    get() = this.items.joinToString { it.name }

fun Order.maxPricedItemValue(): Float {
    return this.items.maxByOrNull { it.price }?.price ?: 0F
}

fun Order.maxPricedItemName(): String = this.items.maxByOrNull { it.price }?.name ?: "NO Products"

// data classes
data class Item(val name: String, val price: Float)
data class Order(val items: Collection<Item>)

// enum classes
enum class Color(private val rgb: Int) {
    RED(0xFF0000),
    BLUE(0x0000FF),
//    GREEN(0x00FF00),
//    YELLOW(0xFFFF00)
    ;

    //    semicolon required above, acts as seperator between constants and methods defined
    fun containsRed() = (this.rgb and RED.rgb != 0)

    fun getColor(color: Color) =
        when (color) {
            BLUE -> "blue"
            RED -> "red"
        }

    fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(BLUE, RED) -> "valid color"
            else -> "invalid color"
        }
}

