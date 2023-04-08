package commands

import collectionObjectsClasses.Route
import commands.utils.Command
import commands.utils.CommandType
import exeptions.CommandExecuteException

/***
 * update id {element} : обновить значение элемента коллекции, id которого равен заданному
 * @author Demid0
 * @since 1.0
 */
class UpdateId: Command(CommandType.MIXED_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): String {
        if (objectArg != null) {
            val id: Long = (singleArg!!).toLong()
            val route = objectArg
            return try {
                var bool = false
                for (element in data.collection) {
                    if (element.getId() == id) {
                        element.update(
                            name = route.getName(),
                            coordinates = route.getCoordinates(),
                            from = route.getFrom(),
                            to = route.getTo(),
                            distance = route.getDistance()
                        )
                        bool = true
                        break
                    }
                }
                if (bool) "Done!"
                else "No element with $id id"
            } catch (e: Exception) {
                "Wrong id format."
            }
        } else throw CommandExecuteException()
    }

}
