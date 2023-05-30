package builders

import commandArgumentsAndTheirsComponents.*
import utils.Packet

class PacketBuilder {
    var commandName: String? = null
    var arguments: ArrayList<CommandArgument> = arrayListOf()

    fun build(): Packet {
        val packet = Packet(commandName!!, arguments)
        return packet
    }

    fun commandType(init: CommandTypeArgumentBuilder.() -> Unit) : CommandTypeArgument {
        val ans = builders.commandType(init)
        arguments.add(ans)
        return ans
    }
    fun commandType(c: CommandType) { commandType { it = c } }
    fun route(init: RouteBuilder.() -> Unit) : Route {
        val ans = builders.route(init)
        arguments.add(ans)
        return ans
    }
    fun route (r: Route) { arguments.add(r) }
    fun string(init: MyStringBuilder.() -> Unit): MyString {
        val ans = builders.string(init)
        arguments.add(ans)
        return ans
    }
    fun string (s: String) { string { it = s } }

    fun argsArray(init: () -> Unit): ArrayList<CommandArgument> {
        init.invoke()
        return arguments
    }
    fun printToClient(string: String): PacketBuilder {
        commandName = "print_to_client"
        string (string)
        return this
    }
}

