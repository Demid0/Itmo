package commands

import collectionObjectsClasses.Route
import commands.utils.Command
import commands.utils.CommandType
import exeptions.CommandExecuteException

/***
 * remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный
 * @author Demid0
 * @since 1.0
 */
class RemoveLower: Command(CommandType.OBJECT_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): String {
        if (objectArg != null) {
            val route = objectArg
            for (element in data.collection) {
                if (element.getDistance() < route.getDistance()) {
                    data.collection.remove(element)
                }
            }
            return "Done!"
        } else throw CommandExecuteException()
    }
}
