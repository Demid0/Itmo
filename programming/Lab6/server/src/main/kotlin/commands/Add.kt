package commands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * add {element} : добавить новый элемент в коллекцию
 * @author Demid0
 * @since 1.0
 */
class Add: ClientCommand(CommandType.OBJECT_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        data.collection.add(objectArg!!)
        return AnswerPacket("Done!")
    }
}