package serializationStrategies.utils

import collectionObjectsClasses.Route
import commands.utils.CommandPacket
import kotlinx.serialization.Serializable

/***
 * Обертка для разных типов сериализации
 * @author Demid0
 * @since 1.0
 */
interface Strategy {
    fun decode(str: String, collection: MutableCollection<Route>): MutableCollection<Route>
    fun decode(str: String, commandPacket: CommandPacket): CommandPacket
    fun encode(collection: MutableCollection<Route>): String
    fun encode(commandPacket: CommandPacket): String
    override fun toString(): String
}