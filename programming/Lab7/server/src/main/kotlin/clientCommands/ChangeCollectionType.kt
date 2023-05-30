package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType

/***
 * change_collection_type type : поменять тип коллекции
 * @author Demid0
 * @since 1.0
 */
class ChangeCollectionType: ClientCommand(CommandType.SINGLE_ARG) {

    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        return printToClientPacket(
            try {
                val newType : String = cast(arguments)
                collectionManager.changeType(newType)
                "Changed"
            } catch (e: NullPointerException) {
                "Unsupported collection type\n${printSupportedTypes()}"
            } catch (e: IndexOutOfBoundsException) {
                "Empty input\n${printSupportedTypes()}"
            }
        )
    }

    private fun printSupportedTypes() : String {
        var out = "You can use this types:\n"
        for (type in collectionManager.getSupportedCollectionTypes()) {
            out += type.key +"\n"
        }
        return out.dropLast(1)
    }
}