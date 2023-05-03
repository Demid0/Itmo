package utils

import commands.Command
import org.koin.core.component.KoinComponent

/***
 * Класс, вызывающий команды
 * @author Demid0
 * @since 1.0
 * @param commands
 * Поддерживаемые типы комманд
 */
class ClientCommandInvoker: KoinComponent {
    val commands = HashMap<String, Command>()

    init {

    }

    fun invoke(argumentPacket: ArgumentPacket): String {
        return commands[argumentPacket.commandName]!!.execute(argumentPacket.singleArg, argumentPacket.objectArg)
    }


}