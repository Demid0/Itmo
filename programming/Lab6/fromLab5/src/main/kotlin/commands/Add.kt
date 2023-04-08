package commands

import collectionObjectsClasses.Route
import commands.utils.Command
import commands.utils.CommandType
import exeptions.CommandExecuteException

/***
 * add {element} : добавить новый элемент в коллекцию
 * @author Demid0
 * @since 1.0
 */
class Add: Command(CommandType.OBJECT_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): String {
        if (objectArg != null ) {
            data.collection.add(objectArg)
            return "Done!"
        }
        else throw CommandExecuteException()
    }
}