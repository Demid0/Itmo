package SerializationStrategies

import CollectionObjectsClasses.Route
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

class YamlStrategy : Strategy {
    override fun decode(str: String) = Yaml.default.decodeFromString<MutableCollection<Route>>(str)
    override fun encode(collection: MutableCollection<Route>) = Yaml.default.encodeToString(collection)
    override fun toString() = "Yaml"
}