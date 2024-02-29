package web.lab4.entities.point

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import web.lab4.repositories.PointRepository

@Service
class PointService {
    @Autowired
    private lateinit var pointRepository: PointRepository

    fun getByOwnerId(ownerId: Long) = pointRepository.findAll().filter { it.ownerId == ownerId }
    fun save(point: Point) = pointRepository.save(point)
    fun deleteAllByOwnerId(ownerId: Long) = pointRepository.deleteAllByOwnerId(ownerId)
    fun findById(id: Int): Point = pointRepository.findById(id).orElseThrow { Exception("point not found") }
    fun deleteById(id: Int, ownerId: Long) = if (this.findById(id).ownerId == ownerId) pointRepository.deleteById(id) else throw Exception("It is not your point")
}