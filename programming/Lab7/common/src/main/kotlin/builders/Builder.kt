package builders


class Builder {
    fun route(init: RouteBuilder.() -> Unit) = RouteBuilder().apply(init).build()
    fun location(init: LocationBuilder.() -> Unit) = LocationBuilder().apply(init).build()
    fun coordinates(init: CoordinatesBuilder.() -> Unit) = CoordinatesBuilder().apply(init).build()
    fun string(init: MyStringBuilder.() -> Unit) = MyStringBuilder().apply(init).build()
    fun commandType(init: CommandTypeArgumentBuilder.() -> Unit) = CommandTypeArgumentBuilder().apply(init).build()
    fun packet(init: PacketBuilder.() -> Unit) = PacketBuilder().apply(init).build()
    fun printToClientPacket(string: String) = PacketBuilder().printToClient(string).build().wrapIntoArray()
}