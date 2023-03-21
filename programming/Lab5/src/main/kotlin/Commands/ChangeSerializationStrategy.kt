package Commands
/***
 * change_serialization_strategy strategy : поменять тип сериализации
 */
class ChangeSerializationStrategy: Command() {
    override fun execute(args: List<String>) {
        try {
            val newType = args[1] + "strategy"
            serializator.changeStrategy(serializator.getStrategy(newType)!!)
            writer.println("Changed!")
        } catch (e: NullPointerException) {
            System.err.println("Unknown serialization strategy.")
            printSupportedStrategies()
        } catch (e: IndexOutOfBoundsException) {
            System.err.println("Empty input.")
            printSupportedStrategies()
        }
    }

    private fun printSupportedStrategies() {
        println("You can use this strategies:")
        for (strategy in serializator.getStrategies()) {
            println(strategy.value.toString())
        }
    }
}