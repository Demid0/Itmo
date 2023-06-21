package utils

import builders.coordinates
import builders.location
import builders.route
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.BufferedReader
import java.io.PrintWriter
import java.util.function.Predicate

typealias ToType<T> = (input: String?) -> T

/***
 * Считывает строки из потока ввода значения полей, проверяет их на правильность и конвертирует в нужный тип
 * @author Demid0
 * @since 1.0
 */
class Asker(val GUI: Boolean = false): KoinComponent {
    private val writerManager : WriterManager by inject()
    private val readerManager : ReaderManager by inject()

    private fun <T> ask(
        printHint: String,
        converter: ToType<T>,
        checker: Predicate<T>
    ): T {
        val writer: PrintWriter = writerManager.get()
        val reader: BufferedReader = readerManager.get()
        val output: T
        writer.print("$printHint > ")
        writer.flush()
        while (true) {
            try {
                var input = reader.readLine()
                input = if (input == "") null else input
                output = converter(input)
                if (checker.test(output)) break
                else throw Exception()
            } catch (_: Exception) {
                if (GUI) throw Exception()
                writer.println("Incorrect input. Try again.")
                writer.flush()
                throw Exception()
            }
        }
        return output
    }

    val ToIntOrNull: ToType<Int?> = { it?.toIntOrNull() }
    val ToLong: ToType<Long> = { it!!.toLong() }
    val ToFloat: ToType<Float> = { it!!.toFloat() }
    val ToFloatOrNull: ToType<Float?> = { it?.toFloatOrNull() }
    val ToDouble: ToType<Double> = { it!!.toDouble() }
    val ToString: ToType<String> = { it!! }

    fun askRoute() = route {
        name = ask("name", ToString) { it != "" }
        coordinates = askCoordinates()
        from = askLocation("from")
        to = askLocation("to")
        distance = ask("distance", ToDouble) { it > 1 }
    }


    private fun askCoordinates() = coordinates {
        x = ask("Coordinates - x", ToFloatOrNull) { it == null || it <= 800 }
        y = ask("Coordinates - y", ToIntOrNull) { true }
    }

    private fun askLocation(Lname: String) = location {
        x = ask("$Lname - x", ToIntOrNull) { true }
        y = ask("$Lname - y", ToFloat) { true }
        z = ask("$Lname - z", ToLong) { true }
        name = ask("$Lname - name", ToString) { it != "" && it.length <= 496}
    }

    fun askLogin() = ask("Enter the username", ToString) { it != "" }
    fun askPassword() = ask("Enter the password", ToString) { it != "" }
}