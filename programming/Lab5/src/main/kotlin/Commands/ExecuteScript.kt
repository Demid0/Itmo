package Commands

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.PrintWriter

class ExecuteScript: Command() {
    override fun execute(args: List<String>) {
        try {
            val file_name = args[1]
            if (scriptStack.contains(file_name)) {
                System.err.println("No way! Recursion.")
                return
            }

            writer.println("Executing $file_name")

            scriptStack.add(file_name)

            val file = File(file_name)
            val fileReader = BufferedReader(InputStreamReader(file.inputStream()))

            val devNull = File("/dev/null")
            val devNullPrinter = PrintWriter(devNull)

            val previousTankReader = reader
            val previousTankWriter = writer

            reader = fileReader
            writer = devNullPrinter

            try {
                while (true) {
                    val input = reader.readLine().split(" ").toMutableList()
                    input.removeAll(setOf("", { input.size }))
                    invoker.invoke(input)
                }
            } catch (e: NullPointerException) {
                scriptStack.remove(file_name)

                writer = previousTankWriter
                reader = previousTankReader

                writer.println("Script $file_name is done.")
            }
        } catch (e: Exception) {
            System.err.println("File not found")
        }
    }
}
/***
 * example
 * /home/demid/Desktop/Itmo/programming/Lab5/abab
 *
 */
