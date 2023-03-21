package Commands

class Info: Command() {
    override fun execute(args: List<String>) {
        writer.println("Information about collection:" +
                "\n\tType: ${data.collection.javaClass.simpleName}" +
                "\n\tSize: ${data.collection.size}" +
                "\nInfo about system:" +
                "\n\tSerialization strategy: ${serializator.getChosenStrategy().toString()}"
        )
    }
}
