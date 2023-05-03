package commands

import collectionObjectsClasses.Route
import utils.Command
import utils.CommandType

/***
 * add {element} : добавить новый элемент в коллекцию
 * @author Demid0
 * @since 1.0
 */
class Add: Command(CommandType.OBJECT_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): String {
        data.collection.add(objectArg!!)
        return "Done!"
    }
}