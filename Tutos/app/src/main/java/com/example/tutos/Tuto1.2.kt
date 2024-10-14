package com.example.tutoriels

/*fun main() {
    /*println(1 == 1)*/
    /*println(1 < 1)*/
    /*val trafficLightColor = "Red"*/
    /*val trafficLightColor = "Green"*/
    val trafficLightColor = "Yellow"
    /*val trafficLightColor = "Black"*/

    if(trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow"){
        println("Slow")
    }
    else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }
}*/


/*fun main() {
   val trafficLightColor = "Yellow"

    when(trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }

}*/


/*fun main() {
    val x = 3
    /*val x = 4*/

    when (x) {
        2 -> println("x is a prime number between 1 and 10.")
        3 -> println("x is a prime number between 1 and 10.")
        5 -> println("x is a prime number between 1 and 10.")
        7 -> println("x is a prime number between 1 and 10.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}*/

/*fun main() {
    val x = 3
    /*val x = 4*/

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}*/
/*fun main() {
    /*val x = 3*/
    /*val x = 8*/
    val x = 12

    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
        else -> println("x isn't a prime number between 1 and 10.")
    }
}*/


/*fun main() {
    /*val trafficLightColor = "Yellow"*/
    val trafficLightColor = "Amber"

    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow" , "Amber" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid traffic-light color")
    }
}*/

/*fun main() {
    val trafficLightColor = "Black"

    val message = if (trafficLightColor == "Red") {
        println("Stop")
    } else if (trafficLightColor == "Yellow") {
        println("Slow")
    } else if (trafficLightColor == "Green") {
        println("Go")
    } else {
        println("Invalid traffic-light color")
    }

}*/

/*fun main() {
                  /* return aucune  resultat*/

    val trafficLightColor = "Black"

    val message =
        if (trafficLightColor == "Red") "Stop"
        else if (trafficLightColor == "Yellow") "Slow"
        else if (trafficLightColor == "Green") "Go"
        else "Invalid traffic-light color"

           /* ajout instruction println() */
    println(message)
}*/

fun main() {
    val trafficLightColor = "Amber"

    val message = when(trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Proceed with caution."
        "Green" -> "Go"
        else -> "Invalid traffic-light color"
    }
    println(message)
}