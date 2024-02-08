package web.lab4.repositories

import org.springframework.data.jpa.repository.JpaRepository
import web.lab4.entities.Point

interface PointRepository: JpaRepository<Point, Int>
