import utils.AnswerPacket
import utils.App
import utils.Serializator
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

fun main(args: Array<String>) {
    val serializator = Serializator()
    val app = App()
    var writer = PrintWriter(System.out)
    var reader = BufferedReader(InputStreamReader(System.`in`))
    val channel = DatagramChannel.open()
    val systemCommandInvoker = SystemCommandInvoker()
    while (true) {
        var packet = app.run(reader, writer)
        while (packet == null) packet = app.run(reader, writer)
        val byteBuffer = ByteBuffer.wrap(serializator.serialize(packet).toByteArray())
        val serverAddress = InetSocketAddress("localhost", 5555)
        channel.send(byteBuffer, serverAddress)
        val ansBuffer = ByteBuffer.wrap(ByteArray(65535))
        channel.receive(ansBuffer)
        val ans = serializator.deserialize(String(ansBuffer.array(), 0, ansBuffer.position()), AnswerPacket())

    }
}