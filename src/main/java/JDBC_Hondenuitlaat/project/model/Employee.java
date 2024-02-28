package JDBC_Hondenuitlaat.project.model;

public class Employee {
    private String employeeNumber;
    private String employeeName;

    public Employee(String employeeNumber, String employeeName) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return String.format("[Medewerker %s - %s]", employeeNumber, employeeName);
    }

}
