package clientCommands

import builders.packet
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType

/***
 * execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 * @author Demid0
 * @since 1.0
 */
class ExecuteScript: ClientCommand(CommandType.SINGLE_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        val file_name: String = cast(arguments)
        return packet {
            commandName = "read_from_file"
            string(file_name)
        }.wrapIntoArray()
    }
}
