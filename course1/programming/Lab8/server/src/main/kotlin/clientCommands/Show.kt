package clientCommands

import builders.packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility

/***
 * show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 * @author Demid0
 * @since 1.0
 */

val show = ClientCommand("show", CommandType.NO_ARG, Visibility.LOGGED_USER, {}) {
        user_id, _ ->
    val collection = collectionManager.collection
    val packets = packet {
        commandName = "clear_table"
    }.wrapIntoArray()
    collection.forEach {
        packets.add(
            packet {
                commandName = "insert_into_table"
                route(it)
            }
        )
    }
    packets
}
