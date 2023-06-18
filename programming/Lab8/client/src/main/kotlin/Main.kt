import org.koin.core.context.startKoin
import tornado.MyApp
import tornadofx.launch
import utils.*
import java.util.logging.Logger


val clientMessageHandler = ClientMessageHandler()

fun main(args: Array<String>) {
    startKoin {
        modules(clientKoinModule)
    }
    try {
        launch<MyApp>()
        while (true) {
            clientMessageHandler.run()
        }
    } catch (e: Exception) {
        Logger.getLogger("EXCEPTIONS").info(e.message)
    }
}