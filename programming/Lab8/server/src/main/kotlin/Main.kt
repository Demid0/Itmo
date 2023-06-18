import org.koin.core.context.startKoin
import utils.*
import java.util.logging.Logger
import kotlin.concurrent.thread

fun main(args: Array<String>)  {
    startKoin {
        modules(dbHandlerModule, serverKoinModule)
    }
    var incorrectPort = true
    val serverMessageHandler = ServerMessageHandler()
    var port: Int
    while (incorrectPort) {
        print("Номер порта: ")
        try {
            port = readln().toInt()
            serverMessageHandler.setConnection(port)
        } catch (e: Exception) {
            e.printStackTrace()
            println("Некорректный номер порта")
            continue
        }
        incorrectPort = false
    }
    try {
        thread { serverMessageHandler.receiveMessage() }
    } catch (e: Exception) {
        Logger.getLogger("Main").info(e.message)
    }
    try {
        thread { serverMessageHandler.executeQuery() }
    } catch (e: Exception) {
        Logger.getLogger("Main").info(e.message)
    }
    try {
        thread { serverMessageHandler.sendMessage() }
    } catch (e: Exception) {
        Logger.getLogger("Main").info(e.message)
    }
}
