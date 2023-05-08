package com.app.employee.service;

import com.app.employee.dto.EmployeeInfo;
import com.app.employee.dto.PhoneNumber;
import com.app.employee.entity.Employee;
import com.app.employee.entity.PhoneNo;
import com.app.employee.messages.ResponseMessage;
import com.app.employee.repository.EmployeeRepository;
import com.app.employee.staticdata.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    public ResponseMessage add(EmployeeInfo employeeInfo) {

        ResponseMessage responseMessage = null;
        List<PhoneNo> phoneNos = new ArrayList<>();
        Employee employee = employeeInfoToEmployee(employeeInfo);
        List<PhoneNo> phoneNoList = employee.getPhoneNumberList();
        employee.setPhoneNumberList(phoneNos);
        Employee newEmployee = (Employee) employeeRepository.save(employee);
        responseMessage = ResponseMessage.withResponseData(newEmployee, "Employee saved Successfully", Constants.INFO_TYPE);
        return responseMessage;
    }

    private Employee employeeInfoToEmployee(EmployeeInfo employeeInfo) {

        if ( employeeInfo == null ) {
            return null;
        }

        Employee employee = new Employee();
        employee.setEmployeeId(employeeInfo.getEmployeeId());
        employee.setFirstName(employeeInfo.getFirstName());
        employee.setLastName(employeeInfo.getLastName());
        employee.setEmail(employeeInfo.getEmail());
        employee.setDOJ(employeeInfo.getDOJ());
        employee.setPhoneNumberList(phoneNumberListToPhoneNoList(employeeInfo.getPhoneNumberList()));

        return employee;
    }

    protected List<PhoneNo> phoneNumberListToPhoneNoList(List<PhoneNumber> phoneNumberList) {
        if ( phoneNumberList == null ) {
            return null;
        }

        List<PhoneNo> list1 = new ArrayList<PhoneNo>( phoneNumberList.size() );
        for ( PhoneNumber phoneNumber : phoneNumberList ) {
            list1.add( phoneNumberToPhoneNo( phoneNumber ) );
        }

        return list1;
    }

    private PhoneNo phoneNumberToPhoneNo(PhoneNumber phoneNumber) {

        if ( phoneNumber == null ) {
            return null;
        }
        PhoneNo phoneNo = new PhoneNo();
        phoneNo.setPhnNum( phoneNumber.getPhnNum() );
        return phoneNo;
    }
}
