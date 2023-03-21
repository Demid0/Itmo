package SerializationStrategies

import CollectionObjectsClasses.Route
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class JsonStrategy: Strategy {
    override fun decode(str: String): MutableCollection<Route> = Json.decodeFromString(str)
    override fun encode(collection: MutableCollection<Route>) = Json.encodeToString(collection)
    override fun toString(): String = "Json"
}