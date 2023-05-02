package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

    @NotNull
    @Id
    private  int empId;

    @Size(min = 4,message = "Please Enter Valid Name")
    private String empName;

    @Size(min = 4,message = "please enter Valid EmailId")
    private String empAddress;

    @Size(min = 10,max = 10,message = "Please Enter Valid EmailId")
    private String empContact;

    @Email
    private String empEmailId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date empDob;


}
