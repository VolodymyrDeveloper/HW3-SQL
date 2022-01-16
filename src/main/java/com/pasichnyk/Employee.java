package com.pasichnyk;

public class Employee {

    private int employeeID;
    private String personName;
    private String occupation;
    private String workingDate;
    private int workingHours;


    public Employee(int employeeID, String personName, String occupation, String workingDate, int workindHours) {
        this.employeeID = employeeID;
        this.personName = personName;
        this.occupation = occupation;
        this.workingDate = workingDate;
        this.workingHours = workindHours;
    }

    @Override
    public String toString() {
        return "com.pasichnyk.Employee{" +
                "employeeID=" + employeeID +
                ", person_name='" + personName + '\'' +
                ", occupation='" + occupation + '\'' +
                ", working_date='" + workingDate + '\'' +
                ", workind_hours=" + workingHours +
                '}';
    }
}
