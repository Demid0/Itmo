package clientCommands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
 * @author Demid0
 * @since 1.0
 */
class RemoveLower: ClientCommand(CommandType.OBJECT_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        val route = objectArg!!
        for (element in collectionManager.collection) {
            if (element.getDistance() < route.getDistance()) {
                collectionManager.collection.remove(element)
            }
        }
        return AnswerPacket("Done!")
    }
}
