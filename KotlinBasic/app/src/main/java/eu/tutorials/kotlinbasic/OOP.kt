package eu.tutorials.kotlinbasic

fun main() {
    var holmes = Person("Sherlock", "Holmes")
    var john = Person()
    var anotherJohn = Person(lastName = "Peterson")

    holmes.stateHobby()
}

class Person (firstName: String = "John", lastName: String = "Watson"){

    // Member Variable
    var age: Int? = null
    var hobby: String = "Watching Netflix"

    // Initializer
    init {
        println("Initialize new person with firstName $firstName and lastName $lastName")
    }

    // Member function
    fun stateHobby() {
        println("My hobby is $hobby")
    }
}