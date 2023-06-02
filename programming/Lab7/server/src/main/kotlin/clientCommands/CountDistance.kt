package clientCommands

import builders.printToClientPacket
import commandArgumentsAndTheirsComponents.CommandArgument
import utils.Packet
import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.Visibility
import java.lang.Exception

/***
 * count_by_distance distance : вывести количество элементов, значение поля distance которых равно заданному
 * count_less_than_distance distance : вывести количество элементов, значение поля distance которых меньше заданного
 * @author Demid0
 * @since 1.0
 */
class CountDistance(val compare: (a: Double, b: Double) -> Boolean): ClientCommand(CommandType.SINGLE_ARG, Visibility.LOGGED_USER) {
    override fun execute(arguments: ArrayList<CommandArgument>, user_id: Long): ArrayList<Packet> {
        return printToClientPacket(
            try {
                val distance: String = cast(arguments)
                val counter = collectionManager.collection.filter { compare(it.getDistance(), distance.toDouble()) }.count()
                "$counter element(s)"
            } catch (e: Exception) {
                "Wrong distance format"
            }
        )
    }

}
//CountDistance { a: Double, b: Double -> a == b }
//CountDistance { a: Double, b: Double -> a < b }