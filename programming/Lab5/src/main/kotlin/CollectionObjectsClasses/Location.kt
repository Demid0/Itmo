package CollectionObjectsClasses

class Location(private var x: Int?, private var y: Float, private var z: Long, private var name: String) {
    override fun toString(): String {
        return "\n\tname: $name\n\tx: $x, y: $y, z: $z"
    }
}
