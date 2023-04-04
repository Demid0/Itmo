package commands

import commands.utils.Command
import commands.utils.CommandType
import java.lang.Exception

/***
 * count_by_distance distance : вывести количество элементов, значение поля distance которых равно заданному
 * count_less_than_distance distance : вывести количество элементов, значение поля distance которых меньше заданного
 * @author Demid0
 * @since 1.0
 */
class CountDistance(val compare: (a: Double, b: Double) -> Boolean): Command(CommandType.SINGLE_ARG) {
    override fun execute(args: Any?): String {
        return try {
            var counter = 0
            val distance: Double = ((args as List<*>)[0] as String).toDouble()
            for (element in data.collection) {
                if (compare(element.getDistance(), distance)) counter++
            }
            "$counter element(s)"
        } catch (e: Exception) {
            "Wrong distance format"
        }
    }

}