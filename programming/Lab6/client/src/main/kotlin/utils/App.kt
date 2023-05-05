package utils

import clientCommands.utils.CommandParser
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.File
import java.io.PrintWriter
import java.util.*

class App: KoinComponent {
    private val asker: Asker by inject()
    private val commandParser: CommandParser by inject()
    private val scriptStack: Stack<String> by inject()
    private val nullWriterManager = WriterManager(PrintWriter(File("/dev/null")))
    fun run(inputReader: ReaderManager, outputWriter: WriterManager): ArgumentPacket? {
        try {
            val reader = inputReader.get()
            val writer = if (scriptStack.isEmpty()) outputWriter.get() else nullWriterManager.get()
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
        } catch (_: NullPointerException) {
            scriptStack.removeLast()
            return null
        }
    }
}