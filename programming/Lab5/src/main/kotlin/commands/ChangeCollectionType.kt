package commands

import commands.utils.Command
import commands.utils.CommandType

/***
 * change_collection_type type : поменять тип коллекции
 * @author Demid0
 * @since 1.0
 */
class ChangeCollectionType: Command(CommandType.SINGLE_ARG) {

    override fun execute(args: Any?): String {
        return try {
            val newType = (args as List<*>)[0] as String
            data.changeType(newType)
            "Changed"
        } catch (e: NullPointerException) {
            "Unsupported collection type\n${printSupportedTypes()}"
        } catch (e: IndexOutOfBoundsException) {
            "Empty input\n${printSupportedTypes()}"
        }
    }

    private fun printSupportedTypes() : String {
        var out = "You can use this types:\n"
        for (type in data.getSupportedCollectionTypes()) {
            out += type.key +"\n"
        }
        return out
    }
}