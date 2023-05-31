package utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/***
 * Класс, загружающий последнее сохраненное состояние системы и коллекции
 * @author Demid0
 * @since 1.0
 */
class Starter: KoinComponent {
    private val serializator: Serializator by inject()
}