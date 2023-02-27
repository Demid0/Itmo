import CollectionObjectsClasses.Route
import Commands.Command

class Data {
    companion object {
        val collection: ArrayDeque<Route> = ArrayDeque()
        private var commands: HashMap<String, Command> = HashMap()
        fun getCommands(): HashMap<String, Command> {
            return commands
        }
        fun addCommand(name: String, command: Command) {
            commands.put(name, command)
        }
    }
}