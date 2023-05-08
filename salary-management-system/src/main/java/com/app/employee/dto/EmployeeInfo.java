package com.app.employee.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeInfo {

    private Long employeeId;

    @NotEmpty(message = "First name can't be empty.")
    private String firstName;

    @NotEmpty(message = "Last name can't be empty.")
    private String LastName;

    @NotEmpty(message = "Please Enter Email Id.")
    private String Email;

    @NotEmpty(message = "Phone Number can't be empty.")
    private List<PhoneNumber> phoneNumberList;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Please provide a date.")
    private Date DOJ;

    @NotNull(message = "salary should not be empty.")
    private Double salary;
}
