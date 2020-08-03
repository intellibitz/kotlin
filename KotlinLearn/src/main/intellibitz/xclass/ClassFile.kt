package xclass

import java.util.*

fun main() {
    fun2()
    funI()
    funCset()
}

val cset = CountingSet<Int>()
fun funCset() {
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}

fun fun2() {
    println("${users.nickname} isSubscribed ${users.isSubscribed} ")
//    object equality
    println(users == users)
//    reference equality
    println(users === users)
    adam likes eve
    println(rect.isSquare)
    println(coolCustomer)
}

val coolCustomer = CoolCustomer()
val rect = createRandomRectangle()
val adam = Person("adam")
val eve = Person("eve")

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

private fun funI() {
    clicky.click()
    fokus.showOff()
}

//default constructor is automatically created.. no () required
open class Customer

//Note: explicit invocation of super class is required .. Customer().. the () cannot be omitted, mandatory
// () not required, if implementing interface.. since interface do not have any constructors
class CoolCustomer : Customer() {
    //Note: if 'data' class is defined, then equals, hascode, tostring, copy and other are automatically generated !!
    override fun toString(): String = "CoolCustomer: " + super.toString()
}

//Note: if 'data' class is defined, then equals, hascode, tostring, copy and other are automatically generated !!
data class Contact(val id: Int, var email: String)

class Person(private val name: String) {
    private val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
        println(this.name + " likes " + other.name)
    }

}

val users = Users("kotlin-user")

// constructor param can be initialized with defaults like any other function
class Users(val nickname: String, val isSubscribed: Boolean = true) {
    //Note: if 'data' class is defined, then equals, hascode, tostring, copy and other are automatically generated !!
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Users) return false
        return nickname == other.nickname && isSubscribed == other.isSubscribed
    }

    //Note: if 'data' class is defined, then equals, hascode, tostring, copy and other are automatically generated !!
    override fun hashCode(): Int = 31 * nickname.hashCode() + isSubscribed.hashCode()
}
//class Users(val nickname: String)
// Users simple definition for regular usage, and the corresponding verbose definition below
/*
class Users constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}
// another definition omitting constructor and init block.. same result
class Users (_nickname: String) {
    val nickname = _nickname
}
*/

class Rectangle(private val height: Int, private val width: Int) {
    //    class properties with custom getters
    val isSquare: Boolean
        get() = height == width
}

val clicky: Clicky = Button()
val fokus: Fokus = Button()

// interface with method definition and default implementation
interface Clicky {
    fun click()
    fun showOff() = println("I'm Clickable!")
}

interface Fokus {
    //    same showoff, conflicting with click.. the implementations must choose either or use both
    fun showOff() = println("I'm Foucusable!")
}

// class extends, implements interface
class Button : Clicky, Fokus {
    override fun click() = println("Button.click..")

    //    must define showoff, cause multiple implementations available through interfaces
    override fun showOff() {
        super<Fokus>.showOff()
        super<Clicky>.showOff()
    }
}

// generic class
class MutableStack<E>(vararg items: E) {
    private val elements = items.toMutableList()
    fun push(element: E) = elements.add(element)
    fun peek(): E = elements.last()
    fun pop(): E = elements.removeAt(elements.size - 1)
    fun isEmpty() = elements.isEmpty()
    private fun size() = elements.size
    override fun toString() = "MutableStack(${elements.joinToString()})" + size()
}

// delegating classes using 'by'
class CountingSet<T>(private val innerSet: MutableCollection<T> = HashSet()) : MutableCollection<T>
// delegate using keyword 'by'
by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

