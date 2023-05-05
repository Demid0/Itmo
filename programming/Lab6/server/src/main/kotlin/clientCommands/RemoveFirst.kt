package clientCommands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType
import java.util.NoSuchElementException
/***
 * remove_first : удалить первый элемент из коллекции
 * @author Demid0
 * @since 1.0
 */
class RemoveFirst: ClientCommand(CommandType.NO_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        return AnswerPacket(try {
            collectionManager.collection.remove(collectionManager.collection.first())
            "Done!"
        }
        catch (e: NoSuchElementException) { "Collection is empty" })
    }
}
