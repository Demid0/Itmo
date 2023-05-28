package builders

class ArgumentsBuilder {
    fun route(init: RouteBuilder.() -> Unit) = RouteBuilder().apply(init).build()
    fun location(init: LocationBuilder.() -> Unit) = LocationBuilder().apply(init).build()
    fun coordinates(init: CoordinatesBuilder.() -> Unit) = CoordinatesBuilder().apply(init).build()
}