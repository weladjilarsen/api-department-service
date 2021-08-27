package com.codewade.department.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department_tbl")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId", nullable = false)
    private Long departmentId;

    @Column(name = "departmentName", nullable = false , length = 50)
    @Length(min = 2, max = 50, message = "OK The departmentName must contains Min 3 Characters and Max 100 Characters")
    @NotNull
    private String departmentName;

    @Length(min = 3, max = 100, message = "The departmentAddress must contains Min 3 Characters and Max 100 Characters")
    @NotNull
    @Column(name = "departmentAddress", nullable = false, length = 100)
    private String departmentAddress;

    @Column(name = "departmentCode", nullable = false, length = 40)
    @Length(min = 2, max = 40, message = "The departmentCode must contains Min 2 Characters and Max 40 Characters")
    @NotNull
    private String departmentCode;
}
