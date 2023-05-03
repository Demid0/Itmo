package utils

import commands.*
import org.koin.core.component.KoinComponent

/***
 * Класс, вызывающий команды
 * @author Demid0
 * @since 1.0
 * @param commands
 * Поддерживаемые типы комманд
 */
class Invoker: KoinComponent {
    fun invoke(command: Command, argumentPacket: ArgumentPacket): String {
        return command.execute(argumentPacket.singleArg, argumentPacket.objectArg)
    }

}