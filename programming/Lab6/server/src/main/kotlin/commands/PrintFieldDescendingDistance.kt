package commands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * print_field_descending_distance : вывести значения поля distance всех элементов в порядке убывания
 * @author Demid0
 * @since 1.0
 */
class PrintFieldDescendingDistance: ClientCommand(CommandType.NO_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        val collection = data.collection.sortedByDescending { it.getDistance() }
        return AnswerPacket(if (collection.isEmpty()) "Collection is empty."
        else {
            var out = "Collection:\n"
            for (element in collection) {
                out += "${element.getDistance()} "
            }
            out
        })
    }
}
