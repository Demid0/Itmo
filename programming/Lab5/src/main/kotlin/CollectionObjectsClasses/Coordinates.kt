package CollectionObjectsClasses

import kotlinx.serialization.Serializable

/***
 * Класс, экземляр которого содержится в экземпляре коллекции в качестве поля
 * @constructor Coordinates(x: Float?, y: Int?)
 *
 */
@Serializable
class Coordinates(private var x: Float?, private var y: Int?) {
    override fun toString(): String {
        return "x: $x, y: $y"
    }
}
