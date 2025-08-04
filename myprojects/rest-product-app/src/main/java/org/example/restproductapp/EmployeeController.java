package org.example.restproductapp;

import jakarta.websocket.server.PathParam;
import model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private List<Employee> allEmployees = new ArrayList<>(Arrays.asList(
            new Employee(10, "Tufail", "Pune", 12400),
            new Employee(11, "Jaya", "Kochi", 1400),
            new Employee(12, "Isha", "Mumbai", 444),
            new Employee(13, "Rakesh", "Pune", 2333),
            new Employee(14, "Neha", "Delhi", 12400)
    ));
    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployee(){
        return allEmployees;
    }

    //    GET A SINGLE RECORD
    @GetMapping("/getEmployee/{empId}")
    public Employee getEmployeeById(@PathVariable("empId")Integer eId){
        return allEmployees.stream().filter(t -> t.getEmployeeId() == eId).findFirst().get();
    }

    @DeleteMapping("/getEmployee/{empId}")
    public List<Employee> deleteEmployee(@PathVariable("empId")Integer eId){
        System.out.println("Removed... :"+eId);
        allEmployees.removeIf(t -> t.getEmployeeId()==(eId));
        return allEmployees;
    }


    @PutMapping("/updateEmployee/{empId}")
    public List<Employee> update(@PathVariable("empId")Integer empId, @RequestBody Employee employee) {
        for(int i=0;i<allEmployees.size();i++){
            Employee p = allEmployees.get(i);
            if(p.getEmployeeId() == empId)
            {
                allEmployees.set(i, employee);
            }
        }
        return allEmployees;
    }

}

