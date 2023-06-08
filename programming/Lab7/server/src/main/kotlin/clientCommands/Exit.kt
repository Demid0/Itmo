package clientCommands

import builders.packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility

/***
 * exit : завершить программу (без сохранения в файл)
 * @author Demid0
 * @since 1.0
 */

val exit = ClientCommand("exit", CommandType.NO_ARG, Visibility.ALL_USERS, {}) {
        user_id, _ ->
    val token = tokens[user_id]
    if (token != null) {// means authorized user
        clients.remove(token)
        tokens.remove(user_id)
    }
    packet {
        commandName = "end_client_session"
    }.wrapIntoArray()
}
