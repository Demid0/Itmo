import org.koin.core.component.KoinComponent
import utils.CommandType

abstract class SystemCommand: KoinComponent {
    abstract fun execute(singleArg: String?, commandType: CommandType?)
}
