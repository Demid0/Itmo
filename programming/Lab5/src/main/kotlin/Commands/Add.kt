package Commands

import Asker
import Data

class Add: Command {
    override fun execute(data: Data, asker: Asker, args: List<String>) {
        data.collection.add(asker.askRoute())
    }
}