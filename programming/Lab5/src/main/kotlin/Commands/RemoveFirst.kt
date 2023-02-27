package Commands

import Data

class RemoveFirst : Command {
    override fun execute(args: List<String>) {
        Data.collection.removeFirst()
    }
}
