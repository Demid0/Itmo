import org.koin.core.component.KoinComponent
import java.net.DatagramPacket
import java.net.DatagramSocket

class Handler: Runnable, KoinComponent {
    private val socket = DatagramSocket(5555)

    override fun run() {
        val byteArray = ByteArray(65535)
        val packet = DatagramPacket(byteArray, byteArray.size)
        receiveMessage(packet)
        val query = unpackMessage(packet)
        println("client message: $query\nclient: ${packet.socketAddress}")
        //execute
        val out = "message accepted\nmessage: $query"
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