package web.lab4.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import web.lab4.entities.Point

interface PointRepository: JpaRepository<Point, Int> {
    @Query(value = "delete from points p where p.ownerId=:ownerId", nativeQuery = true)
    fun deleteAllByOwnerId(@Param("ownerId") ownerId: Long)
}
