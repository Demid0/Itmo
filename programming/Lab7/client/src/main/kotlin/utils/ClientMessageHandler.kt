package utils

import builders.packet
import commandArgumentsAndTheirsComponents.Visibility
import exceptions.SystemCommandInvocationException
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.DatagramChannel

class ClientMessageHandler: Runnable, KoinComponent {
    private val serializator: Serializator by inject()
    private val app: App by inject()
    private val writerManager: WriterManager by inject()
    private val readerManager: ReaderManager by inject()
    private val systemCommandInvoker: SystemCommandInvoker by inject()
    private val channel = DatagramChannel.open()
    private val serverAddress = InetSocketAddress("localhost", 1488)
    private val condition: Condition by inject()
    override fun run() {
        sendRecieveInvoke(getPacket())
    }

    fun sendRecieveInvoke(packet: Packet) {
        if (condition.get() != Visibility.UNLOGGED_USER) {
            packet.clientName = condition.clientName
            packet.password = condition.password
        }
        val byteBuffer = packMessage(packet.wrapIntoArray())
        val ansBuffer = ByteBuffer.wrap(ByteArray(65535))
        sendMessage(byteBuffer, serverAddress)
        receiveMessage(ansBuffer)
        val ans = unpackMessage(ansBuffer)
        condition.clientName = ans.first().clientName
        condition.password = ans.first().password
        try {
            systemCommandInvoker.invoke(ans)
        } catch (e: SystemCommandInvocationException) {
            app.setDefaultCondition(e)
        }
    }

    fun getPacket(): Packet {
        var packet = app.run(readerManager, writerManager)
        while (packet == null) packet = app.run(readerManager, writerManager)
        return packet
    }

    fun packMessage(packet: ArrayList<Packet>) : ByteBuffer {
        return ByteBuffer.wrap(serializator.serialize(packet).toByteArray())
    }

    fun unpackMessage(byteBuffer: ByteBuffer): ArrayList<Packet> {
        return serializator.deserialize(String(byteBuffer.array(), 0, byteBuffer.position()), ArrayList<Packet>())
    }

    fun sendMessage(byteBuffer: ByteBuffer, address: InetSocketAddress) {
        channel.send(byteBuffer, address)
    }

    fun receiveMessage(byteBuffer: ByteBuffer) {
        channel.receive(byteBuffer)
    }

    fun setPossibleCommands() {
        sendRecieveInvoke(packet {
            commandName = "checkout"
            clientName = condition.clientName
            visibility(condition.get())
        })
    }

}
