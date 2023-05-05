import org.koin.core.component.inject
import utils.MessageHandler
import utils.UtilFabric

fun main(args: Array<String>)  {
    val utilFabric = UtilFabric()
    val messageHandler: MessageHandler by utilFabric.inject()
    while (true) {
        messageHandler.run()
    }
}
