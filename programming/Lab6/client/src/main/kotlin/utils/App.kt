package utils

import clientCommands.utils.CommandParser
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap

class App: KoinComponent {
    private val asker: Asker by inject()
    private val commandParser: CommandParser by inject()
    private val scriptStack: ArrayDeque<String> by inject()
    private val readerStack: HashMap<String, BufferedReader> by inject()
    private val nullWriterManager = WriterManager(PrintWriter(File("/dev/null")))

    fun run(readerManager: ReaderManager, writerManager: WriterManager): ArgumentPacket? {
        try {
            val reader = readerManager.get()
            val writer = if (scriptStack.isEmpty()) writerManager.get() else nullWriterManager.get()
            writer.print("> ")
            writer.flush()
            val input = reader.readLine().trim().split(" ").toMutableList()
            input.removeAll(setOf("", { input.size }))
            val packet = commandParser.parse(input)
            if (packet.commandName == null) {
                writer.print("Command not found.\n")
                writer.flush()
                return null
            }
            if (packet.objectArg != null) packet.objectArg = asker.askRoute(reader, writer)
            packet.commandFrom = scriptStack.lastOrNull()
            return packet
        } catch (e: NullPointerException) {
            readerStack.remove(scriptStack.removeLast())
            if(scriptStack.isEmpty()) readerManager.set(BufferedReader(InputStreamReader(System.`in`)))
            return null
        }
    }
}