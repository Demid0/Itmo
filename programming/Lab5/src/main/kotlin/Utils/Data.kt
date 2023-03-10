package Utils

import CollectionObjectsClasses.Route

class Data {
    var collection: MutableCollection<Route> = ArrayDeque()
    private var supportedCollectionTypes: HashMap<String, MutableCollection<Route>> = hashMapOf()
    fun changeType(newType: String) {
        val old = collection
        collection = supportedCollectionTypes[newType.toLowerCase()]!!
        for (element in old) {
            collection.add(element)
        }
    }

    fun addSupportedCollectionType(name: String, collection: MutableCollection<Route>) {
        supportedCollectionTypes[name] = collection
    }
}