package utils

import commands.utils.CommandParser
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.BufferedReader
import java.io.PrintWriter
import java.util.*

class App: KoinComponent {
    private val asker: Asker by inject()
    private val commandParser: CommandParser by inject()
    private val scriptStack: Stack<String> by inject()
    private val nullWriter = PrintWriter("/dev/null")

    fun run(inputReader: BufferedReader, outputWriter: PrintWriter) {
        while (true) {
            var writer = outputWriter
            val reader = inputReader
            writer = if (scriptStack.isEmpty()) writer else nullWriter
            writer.print("> ")
            writer.flush()
            val input = reader.readLine().split(" ").toMutableList()
            input.removeAll(setOf("", { input.size }))
            val packet = commandParser.parse(input)
            if (packet.commandName == null) {
                writer.print("Command not found.\n")
                writer.flush()
                continue
            }
            if (packet.objectArg != null) packet.objectArg = asker.askRoute(reader, writer)
        }
    }
}