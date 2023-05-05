import org.koin.core.component.inject
import org.koin.core.context.startKoin
import utils.MessageHandler
import utils.ServerUtilFabric
import utils.serverKoinModule

fun main(args: Array<String>)  {
    startKoin {
        modules(serverKoinModule)
    }
    val serverUtilFabric = ServerUtilFabric()
    val messageHandler: MessageHandler by serverUtilFabric.inject()
    while (true) {
        messageHandler.run()
    }
}
