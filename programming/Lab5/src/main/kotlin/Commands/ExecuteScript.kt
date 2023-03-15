package Commands

import Utils.Tank
import java.io.BufferedReader
import java.io.EOFException
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.io.PrintWriter

class ExecuteScript: Command {
    override fun execute(tank: Tank, args: List<String>) {
        try {
            val file_name = args[1]
            if (tank.scriptStack.contains(file_name)) {
                System.err.println("No way! Recursion.")
                return
            }

            tank.writer.println("Executing $file_name")

            tank.scriptStack.add(file_name)

            val file = File(file_name)
            val fileReader = BufferedReader(InputStreamReader(file.inputStream()))

            val devNull = File("/dev/null")
            val devNullPrinter = PrintWriter(devNull)

            val previousTankReader = tank.reader
            val previousTankWriter = tank.writer

            tank.reader = fileReader
            tank.writer = devNullPrinter

            try {
                while (true) {
                    val input = tank.reader.readLine().split(" ").toMutableList()
                    input.removeAll(setOf("", { input.size }))
                    tank.invoker.invoke(tank, input)
                }
            } catch (e: NullPointerException) {
                tank.scriptStack.remove(file_name)

                tank.writer = previousTankWriter
                tank.reader = previousTankReader

                tank.writer.println("Script $file_name is done.")
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
