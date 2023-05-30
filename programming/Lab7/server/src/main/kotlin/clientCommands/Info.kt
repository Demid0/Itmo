package clientCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType

/***
 * info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 * @author Demid0
 * @since 1.0
 */
class Info: ClientCommand(CommandType.NO_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        return build.printToClientPacket(
            "Information about collection:" +
                  "\n\tType: ${collectionManager.collection.javaClass.simpleName}" +
                  "\n\tSize: ${collectionManager.collection.size}" +
                  "\nInfo about system:" +
                  "\n\tSerialization strategy: ${serializator.getChosenStrategy().toString()}"
        )
    }
}
