package builders

import commandArgumentsAndTheirsComponents.CommandType
import commandArgumentsAndTheirsComponents.CommandTypeArgument
import commandArgumentsAndTheirsComponents.Visibility
import commandArgumentsAndTheirsComponents.VisibilityArgument

class VisibilityArgumentBuilder {
    var it: Visibility? = null
    fun build() = VisibilityArgument(it!!)
}
