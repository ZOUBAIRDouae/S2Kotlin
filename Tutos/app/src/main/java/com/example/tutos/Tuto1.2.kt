
package com.example.tutoriels



/*fun main() {
    var number: Int? = 10
    println(number)

    number = null
    println(number)
}*/


fun main() {
    val favoriteActor: String? = "Sandra Oh"

    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}