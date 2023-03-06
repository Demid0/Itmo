package Commands

import Asker
import Data
import kotlin.Exception

class ChangeCollectionType: Command {

    override fun execute(data: Data, asker: Asker, args: List<String>) {
        try {
            val newType = args[1]
        } catch (e: Exception) {
            println("Unknown type")
        }
    }

}