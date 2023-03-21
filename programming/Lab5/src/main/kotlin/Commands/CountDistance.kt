package Commands

import java.lang.Exception

/***
 *     count_by_distance distance : вывести количество элементов, значение поля distance которых равно заданному
 *     count_less_than_distance distance : вывести количество элементов, значение поля distance которых меньше заданного
 */
class CountDistance(val compare: (a: Double, b: Double) -> Boolean): Command() {
    override fun execute(args: List<String>) {
        try {
            var counter = 0
            val distance: Double = args[1].toDouble()
            for (element in data.collection) {
                if (compare(element.getDistance(), distance)) counter++
            }
            writer.println("$counter element(s)")
        } catch (e: Exception) {
            System.err.println("Wrong distance format")
        }
    }

}
