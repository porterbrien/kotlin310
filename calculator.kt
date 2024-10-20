import java.util.Scanner

fun main() {
    var loop = false
    val reader = Scanner(System.`in`)
    val history = mutableListOf<String>()

    // Clear the console by printing multiple new lines to simulate clearing.
    fun clearConsole() {
        repeat(20) { println() }
    }

    // Function to display history
    fun displayHistory() {
        if (history.isEmpty()) {
            println("No calculation history available.")
        } else {
            println("Calculation History:")
            history.forEach { println(it) }
        }
    }

    // Function for addition
    fun add(num1: Double, num2: Double) = num1 + num2

    // Function for subtraction
    fun subtract(num1: Double, num2: Double) = num1 - num2

    // Function for multiplication
    fun multiply(num1: Double, num2: Double) = num1 * num2

    // Function for division
    fun divide(num1: Double, num2: Double): Double? {
        return if (num2 != 0.0) num1 / num2 else null
    }

    // Function for modulus
    fun modulus(num1: Double, num2: Double) = num1 % num2

    // Function for exponentiation
    fun exponentiate(base: Double, exponent: Double) = Math.pow(base, exponent)

    // Function for square root
    fun squareRoot(num: Double) = Math.sqrt(num)

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

        println("Enter second number (or type 'sqrt' to calculate square root of the first number): ")
        val input2 = reader.next()

        // Handle square root case
        val num2: Double? = if (input2.lowercase() == "sqrt") {
            null // Square root of num1, no second number needed
        } else {
            input2.toDoubleOrNull().also {
                if (it == null) {
                    println("Invalid input. Please enter a valid number.")
                }
            }
        }

        // Simple calculator app with basic operations
        println("Enter an operation (+, -, *, /, %, ^): ")
        val operator = reader.next()[0]

        val result: Double? = when (operator) {
            '+' -> add(num1, num2 ?: 0.0)
            '-' -> subtract(num1, num2 ?: 0.0)
            '*' -> multiply(num1, num2 ?: 0.0)
            '/' -> {
                if (num2 == null || num2 == 0.0) {
                    println("Division by zero is not allowed.")
                    continue
                }
                divide(num1, num2)
            }
            '%' -> modulus(num1, num2 ?: 0.0)
            '^' -> exponentiate(num1, num2 ?: 0.0)
            'r' -> {
                if (num1 < 0) {
                    println("Cannot compute square root of a negative number.")
                    continue
                } else {
                    squareRoot(num1)
                }
            }
            else -> {
                println("Invalid operator.")
                continue
            }
        }

        // Display the result
        println("The result is: $result")

        // Add to history
        history.add("$num1 $operator ${num2 ?: "N/A"} = $result")
        displayHistory()

        Thread.sleep(3000)
    }

    println("Calculator has been terminated.")
}
