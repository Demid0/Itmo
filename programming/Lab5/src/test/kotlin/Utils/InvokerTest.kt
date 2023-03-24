package Utils

import Commands.Info
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import java.text.SimpleDateFormat
import java.util.*

class InvokerTest {

    @Test
    fun addCommand() {
        startKoin {modules(koinModule)}
        val invoker = Invoker()
        val newCommand = Info()
        val newCommandName = SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Date())
        invoker.addCommand(newCommandName, newCommand)
        assertEquals(invoker.getCommands()[newCommandName], newCommand)
        stopKoin()
    }

    @Test
    fun invoke() {
        startKoin {modules(koinModule)}
        val invoker = Invoker()
        val newCommand = Info()
        val newCommandName = SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Date())
        invoker.addCommand(newCommandName, newCommand)
        assert(invoker.invoke(arrayListOf(newCommandName)))
        stopKoin()
    }
}