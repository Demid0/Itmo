package utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ClientAssistant: KoinComponent {
    private val serializator: Serializator by inject()
    var collectionManager = CollectionManager()
    init {
        //download last system condition
    }

    fun executeQuery(message: String) : String {
        val argumentPacket = deserializeMessage(message)
        val clientCommandInvoker = ClientCommandInvoker()
        val out = clientCommandInvoker.invoke(argumentPacket)
        return serializeMessage(out)
    }

    fun serializeMessage(answerPacket: AnswerPacket) : String {
        return serializator.serialize(answerPacket)
    }

    fun deserializeMessage(message: String) : ArgumentPacket {
        return serializator.deserialize(message, ArgumentPacket())
    }
}
