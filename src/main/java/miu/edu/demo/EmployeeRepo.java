package miu.edu.demo;

import java.util.List;

public interface EmployeeRepo {

    List<Employee> findAll();

    Employee findById(int id);


    void save(Employee employee);

    void delete(int id);

    void update(int id, Employee employee);

    List<Project> getProjectByEmployeeId(int eId);

    void addProjectToEmployee(int empId, int projectId);


    void removeProjectFromEmployee(int empId, int projectId);

    List<Project> findAllProjects();

    List<Project> findProjectsCriteriaQuery( String name, String location);


}
