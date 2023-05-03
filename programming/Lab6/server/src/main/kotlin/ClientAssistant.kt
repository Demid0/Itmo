import utils.ArgumentPacket
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.ClientCommandInvoker
import utils.Serializator

class ClientAssistant: KoinComponent {
    val serializator: Serializator by inject()

    fun executeQuery(message: String) : String {
        val argumentPacket = deserializeMessage(message)
        val clientCommandInvoker = ClientCommandInvoker()
        val out = clientCommandInvoker.invoke(argumentPacket)
    }

    fun serializeMessage(argumentPacket: ArgumentPacket) : String {
        return serializator.serialize(argumentPacket)
    }

    fun deserializeMessage(message: String) : ArgumentPacket {
        return serializator.deserialize(message, ArgumentPacket())
    }
}
