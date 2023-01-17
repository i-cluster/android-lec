package eu.tutorials.kotlinbasic

fun main() {

    /*
    * Lambda expression
    */

    fun sum(a: Int, b: Int) {
        val res = a + b
        println(res)
    }

    val lambdaSum: (Int, Int) -> Int = {a: Int, b: Int -> a + b}              // return Int
    println(lambdaSum(10, 5))

    val shorterLambdaSum = {a: Int, b: Int -> println(a + b)}               // return None
    shorterLambdaSum(10, 5)

    val ac = {a: Int, b: Int -> a+b}
    print(ac(1, 2))

    /*
    * public -> everywhere
    * private -> only within declared block
    * internal -> only inside implemented module
    * open -> can be inherited (default: final)
    * protected -> allow in it and subclass only
    */

    val base = Base()
    println(base.defaultA)
    // println(privateB)
    // println(base.openProtectedC)
    println(base.internalD)
    // base.pro1tectedE()

    val derived = Derived()
    println(derived.defaultA)
    // println(derived.privateB)
    // println(derived.openProtectedC)
    println(derived.internalD)
    // println(derived.protectedE)

    /*
    * Nested Class - cannot access outer class
    * Inner Class - can access outer class
    */

    println(OuterClass.NestedClass().desc)

    var nestedObj = OuterClass.NestedClass()
    nestedObj.foo()

    println(OuterClass().InnerClass().desc)

    var innerObj = OuterClass().InnerClass()
    innerObj.foo()
}


open class Base() {

    var defaultA = 1
    private var privateB = 2                            // private to Base
    protected open val openProtectedC = 3               // visible to Base, Derived
    internal val internalD = 4                          // visible inside this module
    protected fun protectedE() { }

}

class Derived : Base() {

    override val openProtectedC = 5

    // override fun protectedE() {}

    init {
        println(defaultA)
        // println(privateB)
        println(openProtectedC)
        println(internalD)
        protectedE()
    }

}


class OuterClass {
    private var name: String = "Mr X"

    class NestedClass {
        var desc: String = "code inside nested class"
        private var id: Int = 101

        fun foo() {
            // println("name is $name")
            println("Id is $id")
        }
    }

    inner class InnerClass {
        var desc: String = "code inside inner class"
        private var id: Int = 101

        fun foo() {
            println("name is $name")
            println("Id is $id")
        }
    }
}