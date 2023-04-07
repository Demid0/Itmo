package commands

import commands.utils.Command
import commands.utils.CommandType

/***
 * clear : очистить коллекцию
 * @author Demid0
 * @since 1.0
 */
class Clear: Command(CommandType.NO_ARG) {
    override fun execute(args: Any?): String {
        data.collection.clear()
        return "Done!"
    }
}
