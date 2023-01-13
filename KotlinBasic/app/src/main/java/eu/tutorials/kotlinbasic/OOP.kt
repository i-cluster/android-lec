package eu.tutorials.kotlinbasic

import java.lang.IllegalArgumentException

fun main() {
    var holmes = Person("Sherlock", "Holmes", 35)
    var john = Person()
    var anotherJohn = Person(lastName = "Peterson")

    holmes.hobby = "chess"
    holmes.age = 38
    holmes.stateHobby()
    println("Holmes is ${holmes.age}")

    john.hobby = "reading newspaper"
    john.stateHobby()

    var myCar = Car()
    println("Brand is ${myCar.brand}")
    myCar.maxSpeed = 230
    println("Max speed is ${myCar.maxSpeed}")
    println("Model is ${myCar.myModel}")

    val user1 = User(1, "Denis")

    val name = user1.name
    println(name)
    user1.name = "Michael"
    println(user1.name)

    val user2 = User(1, "Michael")
    println(user1.equals(user2))
    println(user1 == user2)

    println("User Detail: $user1")

    // copy method
    val updatedUesr = user1.copy(name = "David")
    println(updatedUesr)

    // Component
    println(updatedUesr.component1())
    println(updatedUesr.component2())

    // Destructuring
    val (departedId, departedName) = updatedUesr
    println("id is $departedId and name is $departedName")
}

class Person(firstName: String = "John", lastName: String = "Watson") {

    // Member Variable
    var age: Int? = null
    var hobby: String = "Watching Netflix"
    var firstName: String? = null

    // Initializer
    init {
        this.firstName = firstName
        println("Initialize new person with firstName $firstName and lastName $lastName")
    }

    // Member Constructor
    constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName) {
        this.age = age
        println("and age $age")
    }

    // Member function
    fun stateHobby() {
        println("$firstName\'s hobby is $hobby")
    }
}

class Car() {
    lateinit var owner: String

    val brand: String = "BMW"
        // Custom Getter
        get() {
            return field.toLowerCase()
        }

    var maxSpeed: Int = 250
        get() = field
        // Custom Setter
        set(value) {
            field = if (value > 0) value else throw IllegalArgumentException("Max speed can not be less than 9")
        }

    var myModel: String = "M5"
        // Private Setter
        private set

    init {
        this.owner = "Frank"
        this.myModel = "M3"
    }
}

data class User(val id: Long, var name:String)