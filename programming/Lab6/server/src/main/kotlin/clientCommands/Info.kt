package clientCommands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 * @author Demid0
 * @since 1.0
 */
class Info: ClientCommand(CommandType.NO_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        return AnswerPacket("Information about collection:" +
                "\n\tType: ${collectionManager.collection.javaClass.simpleName}" +
                "\n\tSize: ${collectionManager.collection.size}" +
                "\nInfo about system:" +
                "\n\tSerialization strategy: ${serializator.getChosenStrategy().toString()}")
    }
}
