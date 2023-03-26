package commands

import commands.utils.Command
import commands.utils.CommandType

/***
 * print_field_descending_distance : вывести значения поля distance всех элементов в порядке убывания
 * @author Demid0
 * @since 1.0
 */
class PrintFieldDescendingDistance: Command(CommandType.NO_ARG) {
    override fun execute(args: Any?): String {
        val collection = data.collection.sortedByDescending { it.getDistance() }
        if (collection.isEmpty()) return "Collection is empty."
        else {
            var out = "Collection:\n"
            for (element in collection) {
                out += "${element.getDistance()} "
            }
            return out + "\n"
        }
    }
}
