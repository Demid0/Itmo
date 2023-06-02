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
        clients[unlogged_client] = ClientAssistant(-32132)
    }

    override fun run() {
        val byteArray = ByteArray(65535)
        val packet = DatagramPacket(byteArray, byteArray.size)
        receiveMessage(packet)
        val query = unpackMessage(packet)
        val query_from = query.first().token
        logger.info("Message from client $query_from")
        if (!clients.contains(query_from)) {
            println("Aboba")
            return
        }
        val out = clients[query_from]!!.executeQuery(query)
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