import app.MyApp
import org.koin.core.context.startKoin
import tornadofx.launch
import utils.ClientMessageHandler
import utils.GUIclientKoinModule

val clientMessageHandler = ClientMessageHandler()

fun main(args: Array<String>) {
    startKoin {
        modules(GUIclientKoinModule)
    }
    launch<MyApp>()
}
