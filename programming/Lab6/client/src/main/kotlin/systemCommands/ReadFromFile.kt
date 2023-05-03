package systemCommands

import utils.CommandType
import java.io.BufferedReader
import java.io.FileReader

class ReadFromFile : SystemCommand() {
    override fun execute(singleArg: String?, commandType: CommandType?) {
        reader = BufferedReader(FileReader(singleArg))
    }
}
