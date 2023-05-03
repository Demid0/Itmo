package clientCommands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 * @author Demid0
 * @since 1.0
 */
class Show: ClientCommand(CommandType.NO_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        val collection = data.collection
        return AnswerPacket(if (collection.isEmpty()) "Collection is empty :("
        else {
            var out = "Collection:\n"
            for (element in collection) {
                out += element.toString() + "\n"
            }
            out.dropLast(1)
        })
    }
}
