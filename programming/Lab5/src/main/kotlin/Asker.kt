import CollectionObjectsClasses.*
import java.lang.Exception
import java.util.function.Predicate

typealias ToType<T> = (input: String?) -> T;

class Asker {
    private fun <T> ask(
        printHint: String,
        converter: ToType<T>,
        checker: Predicate<T>
    ): T {
        var output: T
        println("$printHint > ")
        while (true) {
            val input = readlnOrNull()
            try {
                output = converter(input)
            } catch (e: Exception) {
                println("Incorrect input. Try again.")
                continue
            }
            if (try {
                    checker.test(output)
                } catch (e: Exception) {
                    false
                }
            ) break
            else println("Incorrect input. Try again.")
        }
        return output
    }

    val ToIntOrNull: ToType<Int?> = { it!!.toInt() }
    val ToLong: ToType<Long> = { it!!.toLong() }
    val ToFloat: ToType<Float> = { it!!.toFloat() }
    val ToFloatOrNull: ToType<Float?> = { it!!.toFloat() }
    val ToDouble: ToType<Double> = { it!!.toDouble() }
    val ToString: ToType<String> = { it!! }

    fun askRoute(): Route {
        val name: String = ask("name", ToString) { it != "" }
        val coordinates = askCoordinates()
        val from: Location? = askLocation()
        val to: Location = askLocation()
        val distance: Double = ask("distance", ToDouble) { it > 1 }
        return Route(name, coordinates, from, to, distance)
    }

    private fun askCoordinates(): Coordinates {
        val range = Int.MIN_VALUE..Int.MAX_VALUE
        val x: Float? = ask("Coordinates - x", ToFloatOrNull) { it!! <= 800 }
        val y: Int? = ask("Coordinates - y", ToIntOrNull) { it == null || it in range }
        return Coordinates(x, y)
    }

    private fun askLocation(): Location {
        val x: Int? = ask("Location - x", ToIntOrNull) { true }
        val y: Float = ask("Location - y", ToFloat) { true }
        val z: Long = ask("Location - z", ToLong) { true }
        val name: String = ask("Location - name", ToString) { it != "" }
        return Location(x, y, z, name)
    }
}