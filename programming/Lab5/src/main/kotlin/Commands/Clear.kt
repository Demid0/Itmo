package Commands

import Asker
import Data

class Clear: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        data.collection.clear()
    }
}
