package miu.edu.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectCriteriaRequest {
    private Integer id;
    private String name;
    private Integer estimatedDays;
    private String location;
}
