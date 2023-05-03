package serialization

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.ArgumentPacket

/***
 * Обертка для разных типов сериализации
 * @author Demid0
 * @since 1.0
 */
interface Strategy {
    fun decode(str: String, collection: MutableCollection<Route>): MutableCollection<Route>
    fun encode(collection: MutableCollection<Route>): String
    fun decode(str: String, argumentPacket: ArgumentPacket): ArgumentPacket
    fun encode(argumentPacket: ArgumentPacket): String
    fun decode(str: String, answerPacket: AnswerPacket): AnswerPacket
    fun encode(answerPacket: AnswerPacket): String
    override fun toString(): String
}