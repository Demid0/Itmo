package Commands

import Data
import Invoker

class Clear : Command {
    override fun execute(args: List<String>) {
        Data.collection.clear()
    }
}
