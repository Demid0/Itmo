package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType

/***
 * change_serialization_strategy strategy : поменять тип сериализации
 * @author Demid0
 * @since 1.0
 */
class ChangeSerializationStrategy: ClientCommand(CommandType.SINGLE_ARG) {
    override fun execute(arguments: ArrayList<CommandArgument>): ArrayList<Packet> {
        return printToClientPacket(
            try {
                var newType: String = cast(arguments)
                newType += "strategy"
                serializator.changeStrategy(serializator.getStrategy(newType)!!)
                "Changed"
            } catch (e: NullPointerException) {
                "Unknown serialization strategy\n${printSupportedStrategies()}"
            } catch (e: IndexOutOfBoundsException) {
                "Empty input\n${printSupportedStrategies()}"
            }
        )
    }

    private fun printSupportedStrategies(): String {
        var out = "You can use this strategies:\n"
        for (strategy in serializator.getStrategies()) {
            out += strategy.value.toString() + "\n"
        }
        return out.dropLast(1)
    }
}