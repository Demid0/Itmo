package SerializationStrategies

import CollectionObjectsClasses.Route

interface Strategy {
    fun decode(str: String): MutableCollection<Route>
    fun encode(collection: MutableCollection<Route>): String
    override fun toString(): String

}