package Commands

import Asker
import Data

class RemoveFirst: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        data.collection.remove(data.collection.first())
    }
}
