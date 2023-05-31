package utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.logging.Logger

class ClientAssistant(private val clientName: String, val password: String): KoinComponent {
    private val clientCommandInvoker: ClientCommandInvoker by inject()
    private val collectionManager: CollectionManager by inject()
    private val starter: Starter by inject()
    private val logger = Logger.getLogger("Handler logger")

    fun executeQuery(packets: ArrayList<Packet>) : ArrayList<Packet> {
        logger.info("Executing query to $clientName")
        return clientCommandInvoker.invoke(packets)
    }
}
