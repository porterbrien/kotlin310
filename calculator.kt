import java.util.Scanner

fun main() {

    var loop = false 
    val reader = Scanner(System.`in`)

    // Clear the console by printing multiple new lines to simulate clearing.
    fun clearConsole() {
        repeat(20) { println() }
    }


    while (!loop) {
        clearConsole()

        println("Enter 'quit' to exit or continue with the calculation.")
        println("------------------------------------------------------")

        println("Enter first number (or type 'quit' to exit): ")
        val input1 = reader.next()

        if (input1.lowercase() == "quit") {
            loop = true
            break
        }

        // Convert input1 to a double, handling invalid inputs
        val num1 = input1.toDoubleOrNull()
        if (num1 == null) {
            println("Invalid input. Please enter a valid number.")
            continue
        }

        println("Enter second number: ")
        val input2 = reader.next()

        // Convert input2 to a double, handling invalid inputs
        val num2 = input2.toDoubleOrNull()
        if (num2 == null) {
            println("Invalid input. Please enter a valid number.")
            continue
        }

        // Simple calculator app with basic operations
        println("Enter an operation (+, -, *, /): ")
        val operator = reader.next()[0]

        val result = when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> {
                if (num2 != 0.0) num1 / num2 else {
                    println("Division by zero is not allowed.")
                    continue
                }
            }
            else -> {
                println("Invalid operator.")
                continue
            }
        }

        // Display the result
        println("The result is: $result")
        Thread.sleep(3000)
    }


    println("Calculator has been terminated.")
}
