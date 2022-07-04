package com.c1221g1.pharmacy.repository.employee;


import com.c1221g1.pharmacy.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPositionRepository extends JpaRepository<Position,Integer> {

    @Query(value = "select position_id,position_name from position",nativeQuery=true)
    List<Position> getPositionList();
}
