package miu.edu.demo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Project {

    private int id;
    private String name;
    private Integer estimatedDays;
    private String location;

}
