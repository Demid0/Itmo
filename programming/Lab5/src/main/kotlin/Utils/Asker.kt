package Utils

import CollectionObjectsClasses.Coordinates
import CollectionObjectsClasses.Location
import CollectionObjectsClasses.Route
import java.util.function.Predicate

typealias ToType<T> = (input: String?) -> T

class Asker {
    private fun <T> ask(
        printHint: String,
        converter: ToType<T>,
        checker: Predicate<T>
    ): T {
        var output: T
        println("$printHint > ")
        while (true) {
           try {
               val input = readlnOrNull()
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
        val name: String = ask("name", ToString) { it != "" }
        val coordinates = askCoordinates()
        val from: Location? = askNullableLocation("from")
        val to: Location = askLocation("to")
        val distance: Double = ask("distance", ToDouble) { it > 1 }
        return Route(name, coordinates, from, to, distance)
    }

    private fun askCoordinates(): Coordinates {
        val x: Float? = ask("Coordinates - x", ToFloatOrNull) { it == null || it <= 800 }
        val y: Int? = ask("Coordinates - y", ToIntOrNull) { true }
        return Coordinates(x, y)
    }

    private fun askLocation(Lname: String): Location {
        val x: Int? = ask("$Lname - x", ToIntOrNull) { true }
        val y: Float = ask("$Lname - y", ToFloat) { true }
        val z: Long = ask("$Lname - z", ToLong) { true }
        val name: String = ask("$Lname - name", ToString) { it != "" && it.length <= 496}
        return Location(x, y, z, name)
    }

    private fun askNullableLocation(Lname: String): Location? {
        println("Field \"$Lname\" may null. If you want to make it null - write \"Yes\".")
        val ans = readln().lowercase()
        if (ans == "yes") return null
        else return askLocation(Lname)
    }
}