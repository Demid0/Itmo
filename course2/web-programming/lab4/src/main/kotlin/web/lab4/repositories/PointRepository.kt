package web.lab4.repositories

import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import web.lab4.entities.point.Point

interface PointRepository: JpaRepository<Point, Int> {

    @Transactional
    @Modifying
    @Query(value = "delete from points p where p.owner_id=:ownerId", nativeQuery = true)
    fun deleteAllByOwnerId(@Param("ownerId") ownerId: Long)
}
