package utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.util.logging.Logger

class ServerMessageHandler: Runnable, KoinComponent {
    private val serializator = Serializator()
    private val logger = Logger.getLogger("Handler logger")
    private val socket = DatagramSocket(1488)
    private val clients: HashMap<String, ClientAssistant> by inject()

    init {
        val unlogged_client = "unlogged_user"
        val unlogged_password = "123"
        clients[unlogged_client] = ClientAssistant(unlogged_client, unlogged_password)
    }

    override fun run() {
        val byteArray = ByteArray(65535)
        val packet = DatagramPacket(byteArray, byteArray.size)
        receiveMessage(packet)
        val query = unpackMessage(packet)
        logger.info("Message from client ${query.first().clientName}")
        val client = clients[query.first().clientName]!!
        if (client.password != query.first().password) return
        val out = client.executeQuery(query)
        logger.info("Answer to client \"$out\"")
        sendMessage(packMessage(out, packet))
    }

    fun receiveMessage(datagramPacket: DatagramPacket) {
        socket.receive(datagramPacket)
    }

    fun unpackMessage(datagramPacket: DatagramPacket) : ArrayList<Packet> {
        return deserializeMessage(String(datagramPacket.data, 0, datagramPacket.length))
    }

    fun packMessage(packets: ArrayList<Packet>, packet: DatagramPacket): DatagramPacket {
        val byteArray = serializeMessage(packets).toByteArray()
        packet.setData(byteArray, 0, byteArray.size)
        return packet
    }

    fun sendMessage(datagramPacket: DatagramPacket) {
        socket.send(datagramPacket)
    }

    fun serializeMessage(packets: ArrayList<Packet>) : String {
        return serializator.serialize(packets)
    }

    fun deserializeMessage(message: String) : ArrayList<Packet> {
        return serializator.deserialize(message, ArrayList<Packet>())
    }
}