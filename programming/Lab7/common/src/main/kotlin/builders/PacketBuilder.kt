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
        val ans = Builder().commandType(init)
        arguments.add(ans)
        return ans
    }
    fun route(init: RouteBuilder.() -> Unit) : Route {
        val ans = Builder().route(init)
        arguments.add(ans)
        return ans
    }
    fun string(init: MyStringBuilder.() -> Unit): MyString {
        val ans = Builder().string(init)
        arguments.add(ans)
        return ans
    }
    fun string (s: String) { string { it = s } }
    fun commandType(c: CommandType) { commandType { it = c } }

    fun argsArray(init: () -> Unit): ArrayList<CommandArgument> {
        init.invoke()
        return arguments
    }
}

