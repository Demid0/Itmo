package serializationStrategies

import collectionObjectsClasses.Route
import commands.utils.CommandPacket
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import serializationStrategies.utils.Strategy

/***
 * Обертка для json сериализации
 * @author Demid0
 * @since 1.0
 */
class JsonStrategy: Strategy {
    override fun decode(str: String, collection: MutableCollection<Route>): MutableCollection<Route> = Json.decodeFromString(str)
    override fun decode(str: String, commandPacket: CommandPacket): CommandPacket = Json.decodeFromString(str)
    override fun encode(collection: MutableCollection<Route>) = Json.encodeToString(collection)
    override fun encode(commandPacket: CommandPacket): String = Json.encodeToString(commandPacket)

    override fun toString(): String = "Json"
}