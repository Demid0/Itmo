package clientCommands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * clear : очистить коллекцию
 * @author Demid0
 * @since 1.0
 */
class Clear: ClientCommand(CommandType.NO_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        data.collection.clear()
        return AnswerPacket("Done!")
    }
}
