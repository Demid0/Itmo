package serialization

import collectionObjectsClasses.Route
import utils.ArgumentPacket

/***
 * Обертка для разных типов сериализации
 * @author Demid0
 * @since 1.0
 */
interface Strategy {
    fun decode(str: String, collection: MutableCollection<Route>): MutableCollection<Route>
    fun decode(str: String, argumentPacket: ArgumentPacket): ArgumentPacket
    fun encode(collection: MutableCollection<Route>): String
    fun encode(argumentPacket: ArgumentPacket): String
    override fun toString(): String
}