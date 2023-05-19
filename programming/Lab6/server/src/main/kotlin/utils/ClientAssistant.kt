package utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ClientAssistant(clientName: String): KoinComponent {
    private val clientCommandInvoker: ClientCommandInvoker by inject()
    private var collectionManager = CollectionManager(clientName)
    private val starter: Starter by inject()
    init {
        starter.downloadLastSystemCondition(collectionManager)
    }

    fun executeQuery(packets: ArrayList<Packet>) : ArrayList<Packet> {
        return clientCommandInvoker.invoke(packets, collectionManager)
    }
}
