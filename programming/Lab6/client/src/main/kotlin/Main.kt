import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

fun main(args: Array<String>) {
    val channel = DatagramChannel.open()
    while (true) {
        val byteBuffer = ByteBuffer.wrap(readln().toByteArray())
        val serverAddress = InetSocketAddress("localhost", 5555)
        channel.send(byteBuffer, serverAddress)
        val ansBuffer = ByteBuffer.wrap(ByteArray(65535))
        channel.receive(ansBuffer)
        val ans = String(ansBuffer.array(), 0, ansBuffer.position())
        println(ans)
    }
}