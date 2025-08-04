package model;

public class Employee {

    private int employeeId;
    private String firstName;
    private String city;
    private int salary;


    //create cons and setter and getter

    public Employee(int employeeId, String firstName, String city, int salary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.city = city;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
