package utils

import commands.utils.CommandParser
import commands.utils.Invoker
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.BufferedReader
import java.io.PrintWriter
import java.util.*

class App: KoinComponent {
    private val invoker: Invoker by inject()
    private val asker: Asker by inject()
    private val commandParser: CommandParser by inject()
    private val scriptStack: Stack<String> by inject()
    private val nullWriter = PrintWriter("/dev/null")

    fun run(inputReader: BufferedReader, outputWriter: PrintWriter) {
        while (true) {
            var writer = outputWriter
            val reader = inputReader
            val commandReturnWriter = writer
            writer = if (scriptStack.isEmpty()) writer else nullWriter
            writer.print("> ")
            writer.flush()
            val input = reader.readLine().split(" ").toMutableList()
            input.removeAll(setOf("", { input.size }))
            val command = commandParser.parse(input)
            if (command == null) {
                writer.print("Command not found.\n")
                writer.flush()
                continue
            }
            val args_to_command: Any? = if (command.second == null) null
            else if (command.second == 0) asker.askRoute(reader, writer)
            else if ((command.second as List<*>).size == 2 && (command.second as List<*>)[1] == 0) listOf(
                (command.second as List<*>)[0],
                asker.askRoute(reader, writer)
            )
            else if ((command.second as List<*>).size == 1) command.second
            else {
                writer.print("Wrong args.\n")
                writer.flush()
                continue
            }
            val output = invoker.invoke(command.first, args_to_command)
            commandReturnWriter.println(output)
            commandReturnWriter.flush()
        }
    }
}