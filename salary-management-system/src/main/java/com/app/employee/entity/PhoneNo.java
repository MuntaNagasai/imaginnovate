package com.app.employee.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "phone")
public class PhoneNo {

    private String phnNum;
}
