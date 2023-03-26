package commands

import commands.utils.Command
import commands.utils.CommandType

/***
 * info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 * @author Demid0
 * @since 1.0
 */
class Info: Command(CommandType.NO_ARG) {
    override fun execute(args: Any?): String {
        return "Information about collection:" +
                "\n\tType: ${data.collection.javaClass.simpleName}" +
                "\n\tSize: ${data.collection.size}" +
                "\nInfo about system:" +
                "\n\tSerialization strategy: ${serializator.getChosenStrategy().toString()}"
    }
}
