package Commands

import Asker
import Data

interface Command {
    fun execute(data: Data, asker: Asker, args: List<String>)
}