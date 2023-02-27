package CollectionObjectsClasses

import java.text.SimpleDateFormat
import java.util.*

class Route (private var name: String,
             private var coordinates: Coordinates,
             private var from: Location?,
             private var to: Location,
             private var distance: Double) {
    private var id: Long = 0
    private var creationDate: Date

    init {
        id = 1//setId()
        creationDate = Date()
    }

    override fun toString(): String {
        var formatter = SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
        return "\nname: $name\ncoordinates: ${coordinates.toString()}\nfrom(Location): ${from.toString()}" +
                "\nto(Location): ${to.toString()}\ndistance: $distance\nid: $id\ncreationDate: " +
                formatter.format(creationDate)
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
}
