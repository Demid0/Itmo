package clientCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.MyString
import java.lang.Exception
/***
 * remove_by_id id : удалить элемент из коллекции по его id
 * @author Demid0
 * @since 1.0
 */
class RemoveById: ClientCommand(CommandType.SINGLE_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): Packet {
        return Packet("print_to_client", arrayListOf(
            MyString(try {
            val id: Long = caster.toString(arguments[0]).toLong()
            var bool = false
            for (element in collectionManager.collection) {
                if (element.getId() == id) {
                    collectionManager.collection.remove(element)
                    bool = true
                    break
                }
            }
            if (bool) "Done!"
            else "No element with this id."
        } catch (e: Exception) {
            "Wrong id format."
        })
        ))
    }

}
