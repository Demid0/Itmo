package commands

import collectionObjectsClasses.Route
import commands.utils.Command
import commands.utils.CommandType

/***
 * add {element} : добавить новый элемент в коллекцию
 * @author Demid0
 * @since 1.0
 */
class Add: Command(CommandType.OBJECT_ARG) {
    override fun execute(args: Any?): String {
        return try {
            data.collection.add(args as Route)
            "Done!"
        } catch (e: Exception) {
            "Not added."
        }
    }
}