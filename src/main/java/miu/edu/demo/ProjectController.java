package miu.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    EmployeeRepo employeeService;


    @GetMapping
    public List<Project> findAllProjects(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "location",required = false) String location
    ){
        if(name!=null || location!=null)
            return employeeService.findProjectsCriteriaQuery(name,location);
        else
            return employeeService.findAllProjects();
    }


}
