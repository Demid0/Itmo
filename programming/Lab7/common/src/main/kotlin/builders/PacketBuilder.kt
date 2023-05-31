package builders

import commandArgumentsAndTheirsComponents.*
import utils.Packet

class PacketBuilder {
    var commandName: String? = null
    var arguments: ArrayList<CommandArgument> = arrayListOf()
    var clientName: String = "unlogged_user"
    var password: String = "123"

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

    fun visibility(init: VisibilityArgumentBuilder.() -> Unit) : VisibilityArgument {
        val ans = builders.visibility(init)
        arguments.add(ans)
        return ans
    }
    fun visibility(v: Visibility) { visibility { it = v } }
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

