package CollectionObjectsClasses

import kotlinx.serialization.Serializable

@Serializable
class Coordinates(private var x: Float?, private var y: Int?) {
    override fun toString(): String {
        return "x: $x, y: $y"
    }
}
