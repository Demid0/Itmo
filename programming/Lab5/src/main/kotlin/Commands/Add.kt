package Commands

class Add: Command {
    override fun execute(args: List<String>) {
        Data.collection.add(Asker.askRoute())
    }
}