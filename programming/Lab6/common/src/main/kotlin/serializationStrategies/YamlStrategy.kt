package serializationStrategies

import collectionObjectsClasses.Route
import com.charleskorn.kaml.Yaml
import commands.utils.CommandPacket
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import serializationStrategies.utils.Strategy

/***
 * Обертка для yaml сериализации
 * @author Demid0
 * @since 1.0
 */
class YamlStrategy : Strategy {
    override fun decode(str: String, collection: MutableCollection<Route>): MutableCollection<Route> = Yaml.default.decodeFromString(str)
    override fun decode(str: String, commandPacket: CommandPacket): CommandPacket = Yaml.default.decodeFromString(str)
    override fun encode(collection: MutableCollection<Route>) = Yaml.default.encodeToString(collection)
    override fun encode(commandPacket: CommandPacket): String = Yaml.default.encodeToString(commandPacket)

    override fun toString() = "Yaml"
}