package miu.edu.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    private static List<Employee> employees;
    private static List<Project> projects;
    private static int employeeId = 300;
    static {
        employees = new ArrayList<>();
        projects = new ArrayList<>();
        Project projectX = new Project(1,"X",180,"FL");
        Project projectY = new Project(2,"Y",80,"FL");
        Project projectZ = new Project(3,"Z",60,"IA");
        Project projectQ = new Project(4,"Q",120,"IL");


        Employee emp1 = new Employee(111,"Zaineh",120000,
                new ArrayList<>(Arrays.asList(projectY,projectZ,projectQ)));
        Employee emp2 = new Employee(112,"Yasmeen",140000,
                new ArrayList<>(Arrays.asList(projectX,projectZ)));
        Employee emp3 = new Employee(113,"Mira",110000,
                new ArrayList<>(Arrays.asList(projectX)));

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        projects.add(projectX);
        projects.add(projectY);
        projects.add(projectZ);
        projects.add(projectQ);


    }
        @Override
        public List<Employee> findAll(){
            return employees;
        }

        @Override
        public void save(Employee employee) {
            employee.setId(employeeId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
            employeeId++;
            employees.add(employee);
        }


        @Override
        public void delete(int id) {
            var e = employees
                    .stream()
                    .filter(l -> l.getId() == id)
                    .findFirst().get();
            employees.remove(e);
        }

        @Override
        public void update(int id, Employee p) {
//            Employee toUpdate = findById(id);
//            toUpdate.setName(p.getName());
//            toUpdate.setGpa(p.getGpa());
        }

        @Override
        public Employee findById(int id) {
            return employees
                    .stream()
                    .filter(l -> l.getId() == id)
                    .findFirst()
                    .orElse(null);

        }

        @Override
        public List<Project> getProjectByEmployeeId(int eId){
            return employees.stream()
                    .filter(employee -> employee.getId()==eId)
                    .flatMap(s ->s.getProjectList().stream())
                    .collect(Collectors.toList());
        }

        public void addProjectToEmployee(int empId, int projectId){
            Project p = projects.stream()
                    .filter(project -> project.getId() == projectId)
                    .findFirst().orElse(null);
            Employee e = employees.stream()
                    .filter(employee -> employee.getId() == empId)
                    .findFirst().orElse(null);
            if(e.getProjectList()==null){
                e.setProjectList(new ArrayList<>(Arrays.asList(p)));
            }
            else if (p!=null && !(e.getProjectList().contains(p)))
                e.getProjectList().add(p);
        }

    @Override
    public void removeProjectFromEmployee(int empId, int projectId) {
        Project p = projects.stream()
                .filter(project -> project.getId() == projectId)
                .findFirst().orElse(null);
        Employee e = employees.stream()
                .filter(employee -> employee.getId() == empId)
                .findFirst().orElse(null);
        if ((e.getProjectList().contains(p)))
            e.getProjectList().remove(p);
    }

    @Override
    public List<Project> findAllProjects() {
        return projects;
    }

    @Override
    public List<Project> findProjectsCriteriaQuery( String name, String location){
//        Employee employee = employees.stream()
//                .filter(e -> e.getId()==employeeId)
//                .findFirst().orElse(null);
//        if(employee.getProjectList()==null)
//            return new ArrayList<>();
//
//        var projectList = employee.getProjectList();
//        var projectIds = projectList.stream()
//                .map(p -> p.getId())
//                .collect(Collectors.toList());

        if(name!=null ){
            if(location!=null ){
                // case name & location
                return projects.stream()
                        .filter(p -> p.getName().equalsIgnoreCase(name))
                        .filter(p -> p.getLocation().equalsIgnoreCase(location))
                        .collect(Collectors.toList());
            }
            else{ // case name
                return projects.stream()
                        .filter(p -> p.getName().equalsIgnoreCase(name))
                        .collect(Collectors.toList());
            }
        }
        else{
            if(location!=null){ // case location
                return projects.stream()
                        .filter(p -> p.getLocation().equalsIgnoreCase(location))
                        .collect(Collectors.toList());
            }
            else{ // nothing
                return projects;
            }
        }
    }


}

