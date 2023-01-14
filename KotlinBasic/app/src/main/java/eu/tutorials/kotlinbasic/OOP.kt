package eu.tutorials.kotlinbasic

import java.lang.IllegalArgumentException
import kotlin.math.floor

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

    var myCar = myCar()
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

    /*
    * Inheritance
    */
    var audiA3 = Car(250.0, "A3", "Audi")
    var teslaS = ElectricCar(270.0, "S-Model", "Tesla", 85.0)

    teslaS.extendRange(200.0)
    teslaS.chargetType = "Type2"

    // Polymorphism
    println(audiA3.drive(200.0))
    println(teslaS.drive(200.0))

    teslaS.drive()

    audiA3.brake()
    teslaS.brake()

    teslaS.brake()

    /*
    * Abstract class
    */
    val human = Human("Denis", "England", 70.0, 28.0)
    val elephant = Elephant("Rosy", "India", 5400.0, 25.0)

    human.run()
    elephant.run()

    human.breath()
    elephant.breath()

    /*
    * TypeCasting
    */
    val stringList: List<String> = listOf("Denis", "Frank", "Michael", "Tom")
    val mixedTypeList: List<Any> = listOf("Denis", 312, 5.0, true)

    // for - if
    for (value in mixedTypeList) {
        if (value is Int) {
            println("Integer : $value")
        } else if (value is Double) {
            println("Double: $value with Floor value ${floor(value)}")
        } else if (value is String) {
            println("String: $value of length ${value.length}")
        } else {
            println("Unknown Type")
        }
    }

    // for - when
    for (value in mixedTypeList) {
        when (value) {
            is Int -> println("Integer : $value")
            is Double -> println("Double: $value with Floor value ${floor(value)}")
            is String -> println("String: $value of length ${value.length}")
            else -> println("Unknown Type")
        }
    }

    // Typecasting
    val obj: Any = 1337
    val str: String? = obj as? String
    println(str)
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

class myCar() {
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


interface Drivable{
    val maxSpeed: Double
    fun drive(): String
    fun brake(){
        println("The drivable is braking")
    }
}


// Sub Class, Child Class, Derived Class
open class Car(override val maxSpeed: Double, val name: String, val brand: String) : Drivable {
    open var range: Double = 0.0

    fun extendRange(amount: Double) {
        if(amount > 0)
            range += amount
    }

    override fun drive(): String = "driving the interface drive"

    open fun drive(distance: Double) {
        println("Drive for $distance KM")
    }
}

class ElectricCar(override val maxSpeed: Double, name: String, brand: String, batteryLife: Double)
    : Car(maxSpeed, name, brand) {
    override var range = batteryLife * 5

    var chargetType = "Type1"
    override fun drive(distance: Double) {
        println("Drive for $distance KM on electricity")
    }

    override fun drive(): String {
        return "Drive for $range KM on electricity"
    }

    override fun brake() {
        // super class
        super.brake()

        println("brake inside of electric car")
    }
}


abstract class Mammal(private val name: String, private val origin: String, private val weight: Double) {
    // Abstract Property (Must be overridden by Subclass)
    abstract var maxSpeed: Double

    // Abstract Method (Must be implemented by Subclass)
    abstract fun run()
    abstract fun breath()

    // Concrete Method
    fun displayDetails() {
        println("Name: $name, Origin: $origin, Weight: $weight, Max speed: $maxSpeed")

    }
}

class Human(name: String, origin: String, weight: Double, override var maxSpeed: Double) :
    Mammal(name, origin, weight) {

    override fun run() {
        println("Run on two legs")
    }

    override fun breath() {
        println("Breath through mouth or nose")
    }
}

class Elephant(name: String, origin: String, weight: Double, override var maxSpeed: Double) : Mammal(name, origin, weight) {
    override fun run() {
        println("Run on four legs")
    }

    override fun breath() {
        println("Breath through the trunk")
    }
}