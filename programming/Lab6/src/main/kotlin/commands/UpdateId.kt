package commands

import collectionObjectsClasses.Route
import commands.utils.Command
import commands.utils.CommandType
import java.lang.Exception
/***
 * update id {element} : обновить значение элемента коллекции, id которого равен заданному
 * @author Demid0
 * @since 1.0
 */
class UpdateId: Command(CommandType.MIXED_ARG) {
    override fun execute(args: Any?): String {
        val arg = args as List<*>
        val id: Long = ((arg[0] as List<*>)[0] as String).toLong()
        val route = arg[1] as Route
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
            else "No element with this id"
        } catch (e: Exception) {
            "Wrong id format."
        }
    }

}
