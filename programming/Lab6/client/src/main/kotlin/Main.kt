import clientCommands.utils.CommandParser
import org.koin.core.context.startKoin
import org.koin.dsl.module
import utils.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

val clientKoinModule = module {
    single { CommandParser() }

    single { ReaderManager(BufferedReader(InputStreamReader(System.`in`)))}

    single { WriterManager(PrintWriter(System.out)) }

    single { App() }

    single { Serializator() }

    single { SystemCommandInvoker() }

}
fun main(args: Array<String>) {
    startKoin {
        modules(clientKoinModule)
    }
    val serializator = Serializator()
    val app = App()
    var writer = PrintWriter(System.out)
    var reader = BufferedReader(InputStreamReader(System.`in`))
    val channel = DatagramChannel.open()
    val systemCommandInvoker = SystemCommandInvoker()
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
        var packet = app.run(reader, writer)
        while (packet == null) packet = app.run(reader, writer)
        val byteBuffer = ByteBuffer.wrap(serializator.serialize(packet).toByteArray())
        val serverAddress = InetSocketAddress("localhost", 5555)
        channel.send(byteBuffer, serverAddress)
        val ansBuffer = ByteBuffer.wrap(ByteArray(65535))
        channel.receive(ansBuffer)
        val ans = serializator.deserialize(String(ansBuffer.array(), 0, ansBuffer.position()), AnswerPacket())
        systemCommandInvoker.invoke(ans)
    }
}