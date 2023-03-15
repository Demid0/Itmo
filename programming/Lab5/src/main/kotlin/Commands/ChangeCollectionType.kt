package Commands

import Utils.Tank

class ChangeCollectionType: Command {

    override fun execute(tank: Tank, args: List<String>) {
        try {
            val newType = args[1]
            tank.data.changeType(newType)
        } catch (e: NullPointerException) {
            System.err.println("Unsupported collection type.")
        } catch (e: IndexOutOfBoundsException) {
            System.err.println("Empty input.")
        }
    }

}