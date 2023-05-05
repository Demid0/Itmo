package clientCommands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * change_collection_type type : поменять тип коллекции
 * @author Demid0
 * @since 1.0
 */
class ChangeCollectionType: ClientCommand(CommandType.SINGLE_ARG) {

    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        return AnswerPacket(try {
            val newType = singleArg!!
            collectionManager.changeType(newType)
            "Changed"
        } catch (e: NullPointerException) {
            "Unsupported collection type\n${printSupportedTypes()}"
        } catch (e: IndexOutOfBoundsException) {
            "Empty input\n${printSupportedTypes()}"
        })
    }

    private fun printSupportedTypes() : String {
        var out = "You can use this types:\n"
        for (type in collectionManager.getSupportedCollectionTypes()) {
            out += type.key +"\n"
        }
        return out.dropLast(1)
    }
}