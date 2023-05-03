package commands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
 * @author Demid0
 * @since 1.0
 */
class ExecuteScript: ClientCommand(CommandType.SINGLE_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        val file_name = singleArg!!
        return AnswerPacket("read_from_file", file_name, null)
    }
}
/***
 * example
 * /home/demid/Desktop/Itmo/programming/Lab5/script*
 *
 */
