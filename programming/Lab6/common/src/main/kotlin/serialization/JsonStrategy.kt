package serialization

import collectionObjectsClasses.Route
import utils.ArgumentPacket
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import utils.AnswerPacket

/***
 * Обертка для json сериализации
 * @author Demid0
 * @since 1.0
 */
class JsonStrategy: Strategy {
    override fun decode(str: String, collection: MutableCollection<Route>): MutableCollection<Route> = Json.decodeFromString(str)
    override fun decode(str: String, argumentPacket: ArgumentPacket): ArgumentPacket = Json.decodeFromString(str)
    override fun decode(str: String, answerPacket: AnswerPacket): AnswerPacket = Json.decodeFromString(str)
    override fun encode(collection: MutableCollection<Route>) = Json.encodeToString(collection)
    override fun encode(argumentPacket: ArgumentPacket) = Json.encodeToString(argumentPacket)
    override fun encode(answerPacket: AnswerPacket) = Json.encodeToString(answerPacket)
    override fun toString(): String = "Json"
}