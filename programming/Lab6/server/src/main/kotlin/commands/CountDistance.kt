package commands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType
import java.lang.Exception

/***
 * count_by_distance distance : вывести количество элементов, значение поля distance которых равно заданному
 * count_less_than_distance distance : вывести количество элементов, значение поля distance которых меньше заданного
 * @author Demid0
 * @since 1.0
 */
class CountDistance(val compare: (a: Double, b: Double) -> Boolean): ClientCommand(CommandType.SINGLE_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        return AnswerPacket(try {
            var counter = 0
            val distance: Double = singleArg!!.toDouble()
            for (element in data.collection) {
                if (compare(element.getDistance(), distance)) counter++
            }
            "$counter element(s)"
        } catch (e: Exception) {
            "Wrong distance format"
        })
    }

}
//CountDistance { a: Double, b: Double -> a == b }
//CountDistance { a: Double, b: Double -> a < b }