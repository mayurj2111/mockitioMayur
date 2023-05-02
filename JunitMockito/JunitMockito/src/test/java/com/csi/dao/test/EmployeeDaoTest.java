package com.csi.dao.test;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoTest {

    @Autowired
    EmployeeDao employeeDaoImpl;

    @MockBean
    EmployeeRepo employeeRepo;


    @Test
    public void saveDataTest(){
        Employee employee= new Employee(12,"sumit","Pune","23656545","sumit@csi.com",new Date());

        employeeDaoImpl.saveData(employee);
        verify(employeeRepo,times(1)).save(employee);

    }

    @Test
    public void getAllDataTest(){

        when(employeeRepo.findAll()).thenReturn(Stream.of(new Employee(11,"Gokul","Pune","23656545","gokul@csi.com",new Date()),
                new Employee(12,"sumit","Pune","23656545","sumit@csi.com",new Date()),
                new Employee(13,"gaurav","Pune","23656545","gaurav@csi.com",new Date())).collect(Collectors.toList()));

        assertEquals(3,employeeDaoImpl.getAllData().size());
    }

    @Test
    public void getDataByIdTest(){
        Employee employee= new Employee(12,"sumit","Pune","23656545","sumit@csi.com",new Date());

        employeeDaoImpl.getDataById(12);
        verify(employeeRepo,times(1)).findById(employee.getEmpId());

    }

    @Test
    public void updateDataTest(){
        Employee employee= new Employee(12,"sumit","Pune","23656545","sumit@csi.com",new Date());

        employeeDaoImpl.updateData(employee);
        verify(employeeRepo,times(1)).save(employee);

    }

    @Test
    public void deleteByIdTest(){
        Employee employee= new Employee(12,"sumit","Pune","23656545","sumit@csi.com",new Date());

        employeeDaoImpl.deleteDataById(12);
        verify(employeeRepo,times(1)).deleteById(employee.getEmpId());

    }


}
