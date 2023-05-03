package commands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * change_serialization_strategy strategy : поменять тип сериализации
 * @author Demid0
 * @since 1.0
 */
class ChangeSerializationStrategy: ClientCommand(CommandType.SINGLE_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        return AnswerPacket(try {
            val newType = singleArg!! + "strategy"
            serializator.changeStrategy(serializator.getStrategy(newType)!!)
            "Changed"
        } catch (e: NullPointerException) {
            "Unknown serialization strategy\n${printSupportedStrategies()}"
        } catch (e: IndexOutOfBoundsException) {
            "Empty input\n${printSupportedStrategies()}"
        })
    }

    private fun printSupportedStrategies(): String {
        var out = "You can use this strategies:\n"
        for (strategy in serializator.getStrategies()) {
            out += strategy.value.toString() + "\n"
        }
        return out.dropLast(1)
    }
}