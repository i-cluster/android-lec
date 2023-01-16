package eu.tutorials.kotlinbasic

fun main() {

    /*
    * Array
    */

    // val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
    // val numbers = intArrayOf(1, 2, 3, 4, 5)

    val numbers = arrayOf(1, 2, 3, 4, 5, 6)
    println(numbers)
    println(numbers.contentToString())

    val numbersD: DoubleArray = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val days = arrayOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

    val fruits = arrayOf(Fruit("Apple", 2.5), Fruit("Grape", 3.5))
    println(fruits.contentToString())

    for (index in fruits.indices) {
        println("${fruits[index].name} is in index $index")
    }

    /*
    * List
    */
    val months = listOf("January", "February", "March", "April", "May")
    println(months.size)
    println(months[2])

    val anotherMonths = months.toMutableList()
    val newMonths = arrayOf("June", "July", "August", "September", "October", "November")
    anotherMonths.addAll(newMonths)
    anotherMonths.add("December")
    println(anotherMonths)

    val mutableDays = mutableListOf<String>("Mon", "Tue", "Wed")
    mutableDays.add("Thu")
    mutableDays.removeAt(2)
    println(mutableDays)

    val removeList = mutableListOf<String>("Tue", "Thu")
    mutableDays.removeAll(removeList)
    println(mutableDays)

    /*
    * Set
    */

    val fruitSet = setOf("Orange", "Apple", "Grape", "Apple", "Mango")
    println(fruitSet.size)

    println(fruitSet)
    println(fruitSet.toSortedSet())

    val fruitList = fruitSet.toMutableList()
    fruitList.add("Watermelon")
    fruitList.add("Pear")
    println(fruitList.elementAt(4))

    /*
    * Map
    */

    val daysOfTheWeek = mapOf(1 to "Mon", 2 to "Tue", 3 to "Wed")

    for (key in daysOfTheWeek.keys) {
        println("$key is to ${daysOfTheWeek[key]}")
    }

    val fruitMap = mapOf(1 to Fruit("Grape", 2.5), 2 to Fruit("Apple", 1.0))

    val newDaysOfWeek = daysOfTheWeek.toMutableMap()
    newDaysOfWeek[4] = "Thu"
    newDaysOfWeek[5] = "Fri"

    println(newDaysOfWeek.toSortedMap())
}

data class Fruit(val name: String, val price: Double)