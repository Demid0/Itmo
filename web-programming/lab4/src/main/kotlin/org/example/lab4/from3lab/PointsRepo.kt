package org.example.lab4.from3lab

import org.springframework.data.jpa.repository.JpaRepository

interface PointsRepo: JpaRepository<Point, Long> {
}