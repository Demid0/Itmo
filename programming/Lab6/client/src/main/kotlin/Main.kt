import org.koin.core.component.inject
import org.koin.core.context.startKoin
import utils.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel
import java.util.*

fun main(args: Array<String>) {
    startKoin {
        modules(clientKoinModule)
    }
    val fabric = ClientUtilsFabric()
    val serializator: Serializator by fabric.inject()
    val app: App by fabric.inject()
    val writerManager: WriterManager by fabric.inject()
    val readerManager: ReaderManager by fabric.inject()
    val systemCommandInvoker: SystemCommandInvoker by fabric.inject()

    val channel = DatagramChannel.open()
    /****
     *
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *     ДОБАВИТЬ ПРОВЕРКУ РЕКУРСИИ SCRIPTSTACK
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *   ВЫНЕСТИ ВЗАИМОДЕЙСТВИЕ С СЕРВЕРОМ В HANDLE
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *
     */
    while (true) {
        var packet = app.run(readerManager, writerManager)
        while (packet == null) packet = app.run(readerManager, writerManager)
        val byteBuffer = ByteBuffer.wrap(serializator.serialize(packet).toByteArray())
        val serverAddress = InetSocketAddress("localhost", 5555)
        channel.send(byteBuffer, serverAddress)
        val ansBuffer = ByteBuffer.wrap(ByteArray(65535))
        channel.receive(ansBuffer)
        val ans = serializator.deserialize(String(ansBuffer.array(), 0, ansBuffer.position()), AnswerPacket())
        systemCommandInvoker.invoke(ans)
    }
}