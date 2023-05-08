package com.app.employee.entity;

import com.app.employee.dto.PhoneNumber;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @Column(name = "firstName", nullable = false )
    private String firstName;

    @Column(name = "firstName", nullable = false )
    private String LastName;

    @Column(name = "firstName", nullable = false )
    private String Email;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @Column(name = "firstName", nullable = false )
    private List<PhoneNo> phoneNumberList;

    @Column(name = "firstName", nullable = false )
    private Date DOJ;

    @Column(name = "firstName", nullable = false )
    private Double salary;
}
