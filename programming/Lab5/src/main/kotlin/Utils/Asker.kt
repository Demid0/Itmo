package Utils

import CollectionObjectsClasses.Coordinates
import CollectionObjectsClasses.Location
import CollectionObjectsClasses.Route
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.function.Predicate

typealias ToType<T> = (input: String?) -> T

class Asker(var inputF: InputStreamReader, var outputF: PrintWriter) {
    private fun <T> ask(
        reader: InputStreamReader = inputF,
        writer: PrintWriter = outputF,
        printHint: String,
        converter: ToType<T>,
        checker: Predicate<T>
    ): T {
        var output: T
        println("$printHint > ")
        while (true) {
           try {
               val input = reader.read().toString()
               writer.println(input)
               writer.flush()
               output = converter(input)
               if (checker.test(output)) break
               else throw Exception()
           } catch (e: Exception) {
               println("Incorrect input. Try again.")
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

    fun askRoute(): Route {
        val name: String = ask(inputF, outputF, "name", ToString) { it != "" }
        val coordinates = askCoordinates()
        val from: Location? = askNullableLocation("from")
        val to: Location = askLocation("to")
        val distance: Double = ask(inputF, outputF, "distance", ToDouble) { it > 1 }
        return Route(name, coordinates, from, to, distance)
    }

    private fun askCoordinates(): Coordinates {
        val x: Float? = ask(inputF, outputF, "Coordinates - x", ToFloatOrNull) { it == null || it <= 800 }
        val y: Int? = ask(inputF, outputF, "Coordinates - y", ToIntOrNull) { true }
        return Coordinates(x, y)
    }

    private fun askLocation(Lname: String): Location {
        val x: Int? = ask(inputF, outputF, "$Lname - x", ToIntOrNull) { true }
        val y: Float = ask(inputF, outputF, "$Lname - y", ToFloat) { true }
        val z: Long = ask(inputF, outputF, "$Lname - z", ToLong) { true }
        val name: String = ask(inputF, outputF, "$Lname - name", ToString) { it != "" && it.length <= 496}
        return Location(x, y, z, name)
    }

    private fun askNullableLocation(Lname: String): Location? {
        val ans = ask(inputF, outputF, "$Lname is nullable field. If you want to make it null, print \"yes\".", ToString) {true}
        return if (ans == "yes") null
        else askLocation(Lname)
    }
}