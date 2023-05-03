package serialization

import collectionObjectsClasses.Route
import com.charleskorn.kaml.Yaml
import utils.ArgumentPacket
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

/***
 * Обертка для yaml сериализации
 * @author Demid0
 * @since 1.0
 */
class YamlStrategy : Strategy {
    override fun decode(str: String, collection: MutableCollection<Route>): MutableCollection<Route> = Yaml.default.decodeFromString(str)
    override fun decode(str: String, argumentPacket: ArgumentPacket): ArgumentPacket = Yaml.default.decodeFromString(str)
    override fun encode(collection: MutableCollection<Route>) = Yaml.default.encodeToString(collection)
    override fun encode(argumentPacket: ArgumentPacket): String = Yaml.default.encodeToString(argumentPacket)

    override fun toString() = "Yaml"
}