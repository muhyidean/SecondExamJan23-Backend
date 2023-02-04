package miu.edu.demo;

import miu.edu.demo.dto.ProjectCriteriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeService;


    @GetMapping
    public List<Employee> findAll(){
            return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @PostMapping()
    public void save(@RequestBody Employee employee){
        employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Employee employee) {
//        employeeService.update(id, employee);
    }

    @GetMapping("/{id}/projects")
    public List<Project> findCourses(@PathVariable("id") int id){
        return employeeService.getProjectByEmployeeId(id);
    }



    @PutMapping("{eid}/projects/{pid}")
    public void addProjectToEmployee(@PathVariable("eid") int eid, @PathVariable("pid") int pid){
        employeeService.addProjectToEmployee(eid,pid);
    }

    @DeleteMapping("{eid}/projects/{pid}")
    public void removeProjectFromEmployee(@PathVariable("eid") int eid, @PathVariable("pid") int pid){
        employeeService.removeProjectFromEmployee(eid,pid);
    }

    }


