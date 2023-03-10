package CollectionObjectsClasses

import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
class Route (private var name: String,
             private var coordinates: Coordinates,
             private var from: Location?,
             private var to: Location,
             private var distance: Double) {
    private var id: Long = 0
    private var creationDate = SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Date())

    override fun toString(): String {
        return "\nname: $name\ncoordinates: $coordinates\nfrom(Location): ${from.toString()}" +
                "\nto(Location): $to\ndistance: $distance\nid: $id\ncreationDate: $creationDate"
    }

    fun getId(): Long = id
    fun getName(): String = name
    fun getCoordinates(): Coordinates = coordinates
    fun getFrom(): Location? = from
    fun getTo(): Location = to
    fun getDistance(): Double = distance

    fun update(name: String = this.name,
               coordinates: Coordinates = this.coordinates,
               from: Location? = this.from,
               to: Location = this.to,
               distance: Double = this.distance) {
        this.name = name
        this.coordinates = coordinates
        this.from = from
        this.to = to
        this.distance = distance
    }
    fun setId(id: Long) {
        this.id = id
    }
}
