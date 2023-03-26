package commands

import commands.utils.Command
import commands.utils.CommandType
import java.util.NoSuchElementException
/***
 * remove_first : удалить первый элемент из коллекции
 * @author Demid0
 * @since 1.0
 */
class RemoveFirst: Command(CommandType.NO_ARG) {
    override fun execute(args: Any?): String {
        return try {
            data.collection.remove(data.collection.first())
            "Done!"
        }
        catch (e: NoSuchElementException) { "Collection is empty" }
        catch (e: Exception) { "Something went wrong" }
    }
}
