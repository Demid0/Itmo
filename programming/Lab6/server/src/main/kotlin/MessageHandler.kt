import org.koin.core.component.KoinComponent
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.SocketAddress
import java.util.logging.Logger

class MessageHandler: Runnable, KoinComponent {

    private val logger = Logger.getLogger("Handler logger")
    private val socket = DatagramSocket(5555)

    override fun run() {
        val byteArray = ByteArray(65535)
        val packet = DatagramPacket(byteArray, byteArray.size)
        receiveMessage(packet)
        val clients = HashMap<SocketAddress, ClientAssistant>()
        val clientName = packet.socketAddress
        if (clients[clientName] == null) {
            logger.info("New client: ${clientName.toString()}")
            clients[clientName] = ClientAssistant()
        }
        logger.info("Message from client ${clientName.toString()}")
        val out = clients[clientName]!!.executeQuery(unpackMessage(packet))
        logger.info("Answer to client \"$out\"")
        sendMessage(packMessage(out, packet))
    }

    fun receiveMessage(datagramPacket: DatagramPacket) {
        socket.receive(datagramPacket)
    }

    fun unpackMessage(datagramPacket: DatagramPacket) : String {
        return String(datagramPacket.data, 0, datagramPacket.length)
    }

    fun packMessage(string: String, packet: DatagramPacket): DatagramPacket {
        val byteArray = string.toByteArray()
        packet.setData(byteArray, 0, byteArray.size)
        return packet
    }

    fun sendMessage(datagramPacket: DatagramPacket) {
        socket.send(datagramPacket)
    }
}