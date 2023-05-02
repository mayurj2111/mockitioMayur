package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDao employeeDao;

    public Employee saveData (Employee employee){
        return employeeDao.saveData(employee);
    }

    public Optional<Employee> getDataById(int empId){
        return employeeDao.getDataById(empId);
    }

    public List<Employee> getAllData(){
        return employeeDao.getAllData();
    }
    public Employee updateData(Employee employee){
        return employeeDao.updateData(employee);
    }
    public void deleteDataById(int empId){
        employeeDao.deleteDataById(empId);
    }

}
