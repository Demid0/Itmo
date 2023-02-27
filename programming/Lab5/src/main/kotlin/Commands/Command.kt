package Commands

interface Command {
    fun execute(args: List<String>)
}