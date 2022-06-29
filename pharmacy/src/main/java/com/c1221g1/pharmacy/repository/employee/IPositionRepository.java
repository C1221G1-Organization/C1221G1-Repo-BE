package com.c1221g1.pharmacy.repository.employee;

import com.c1221g1.pharmacy.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer> {
}
