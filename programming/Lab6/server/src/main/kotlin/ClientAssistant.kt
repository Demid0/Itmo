import commands.utils.CommandPacket
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import serializationStrategies.utils.Serializator

class ClientAssistant: KoinComponent {
    val serializator: Serializator by inject()

    fun executeQuery(message: String) : String {
        val commandPacket = deserializeMessage(message)

    }

    fun serializeMessage(commandPacket: CommandPacket) : String {
        return serializator.serialize(commandPacket)
    }

    fun deserializeMessage(message: String) : CommandPacket {
        return serializator.deserialize(message, CommandPacket())
    }
}
