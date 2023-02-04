package miu.edu.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Employee {


    private int id;
    private String name;
    private double salary;
    private List<Project> projectList;

}
