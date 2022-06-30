package com.c1221g1.pharmacy.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;
    private String positionName;

    @JsonBackReference(value = "employeeList")
    @OneToMany(mappedBy = "position")
    private List<Employee> employeeList;
}
