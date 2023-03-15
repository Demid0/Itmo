package Serialization.Strategies

import CollectionObjectsClasses.Route

interface Strategy {
    fun decode(str: String) : Route
    fun encode(obj: Route): String
    override fun toString(): String
}