package Serialization.Strategies

import CollectionObjectsClasses.Route
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

class YamlStrategy: Strategy {
    override fun decode(str: String) : Route = Yaml.default.decodeFromString(str)
    override fun encode(obj: Route) = Yaml.default.encodeToString(obj)
}
