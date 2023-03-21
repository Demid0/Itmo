package CollectionObjectsClasses

import kotlinx.serialization.Serializable

/***
 * Класс, экземляр которого содержится в экземпляре коллекции в качестве поля
 * @constructor Location(x: Int?, y: Float, z: Long, name: String)
 *
 */
@Serializable
class Location(private var x: Int?, private var y: Float, private var z: Long, private var name: String) {
    override fun toString(): String {
        return "\n\tname: $name\n\tx: $x, y: $y, z: $z"
    }
}
