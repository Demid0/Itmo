package web.lab4.repo

import org.springframework.data.jpa.repository.JpaRepository
import web.lab4.domain.Point

interface PointRepo: JpaRepository<Point, Int>
