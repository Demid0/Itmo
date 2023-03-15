package Serialization.Strategies

import CollectionObjectsClasses.Route
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class JsonStrategy: Strategy {
    override fun decode(str: String): Route = Json.decodeFromString(str)
    override fun encode(obj: Route) = Json.encodeToString(obj)
    override fun toString(): String = "Json"
}