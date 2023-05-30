package builders

import commandArgumentsAndTheirsComponents.Coordinates
import commandArgumentsAndTheirsComponents.Location
import commandArgumentsAndTheirsComponents.Route

class RouteBuilder {
    var name: String? = null
    var coordinates: Coordinates? = null
    var from: Location? = null
    var to: Location? = null
    var distance: Double? = null

    fun build() = Route(name!!, coordinates!!, from, to!!, distance!!)

    fun location(init: LocationBuilder.() -> Unit) = builders.location(init)
    fun coordinates(init: CoordinatesBuilder.() -> Unit) = builders.coordinates(init)
}