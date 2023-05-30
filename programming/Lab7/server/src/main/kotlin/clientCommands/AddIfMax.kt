package clientCommands

import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType

/***
 * add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
 * @author Demid0
 * @since 1.0
 */
class AddIfMax: ClientCommand(CommandType.OBJECT_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val route = caster.toRoute(arguments[0])
        for (element in collectionManager.collection) {
            if (element.getDistance() >= route.getDistance()) {
                return builder.packet {
                    commandName = "print_to_client"
                    string ("I didn't add it")
                }.wrapIntoArray()
            }
        }
        collectionManager.collection.add(route)
        return builder.packet {
            commandName = "print_to_client"
            string ("Done!")
        }.wrapIntoArray()
    }

}
