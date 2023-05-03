package commands

import collectionObjectsClasses.Route
import utils.AnswerPacket
import utils.CommandType

/***
 * add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
 * @author Demid0
 * @since 1.0
 */
class AddIfMax: ClientCommand(CommandType.OBJECT_ARG) {
    override fun execute(singleArg: String?, objectArg: Route?): AnswerPacket {
        val route = objectArg!!
        for (element in data.collection) {
            if (element.getDistance() >= route.getDistance()) {
                return AnswerPacket("I didn't add it")
            }
        }
        data.collection.add(route)
        return AnswerPacket("Done!")
    }

}
