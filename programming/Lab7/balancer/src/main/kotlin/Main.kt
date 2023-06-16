import kotlin.concurrent.thread

fun main(args: Array<String>) {
    val balancerMessageHandler = BalancerMessageHandler()
    thread { balancerMessageHandler.listenClients() }
    thread { balancerMessageHandler.listenNewServers() }
    thread { balancerMessageHandler.sendToServerAndReceiveAnswer() }
    thread { balancerMessageHandler.sendAnswerToClient() }
}
