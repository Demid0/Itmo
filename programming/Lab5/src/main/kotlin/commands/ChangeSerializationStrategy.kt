package commands

import commands.utils.Command
import commands.utils.CommandType

/***
 * change_serialization_strategy strategy : поменять тип сериализации
 * @author Demid0
 * @since 1.0
 */
class ChangeSerializationStrategy: Command(CommandType.SINGLE_ARG) {
    override fun execute(args: Any?): String {
        return try {
            val newType = (args as List<*>)[0] as String + "strategy"
            serializator.changeStrategy(serializator.getStrategy(newType)!!)
            "Changed"
        } catch (e: NullPointerException) {
            "Unknown serialization strategy\n${printSupportedStrategies()}"
        } catch (e: IndexOutOfBoundsException) {
            "Empty input\n${printSupportedStrategies()}"
        }
    }

    private fun printSupportedStrategies(): String {
        var out = "You can use this strategies:\n"
        for (strategy in serializator.getStrategies()) {
            out += strategy.value.toString() + "\n"
        }
        return out.dropLast(1)
    }
}