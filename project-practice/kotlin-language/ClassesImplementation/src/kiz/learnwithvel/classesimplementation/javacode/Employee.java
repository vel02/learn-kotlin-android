package kiz.learnwithvel.classesimplementation.javacode;

public class Employee {

    private final String mFullName;
    private final String mDepartment;
    private final Double mSalary;
    private final String mWorkedAt;

    public Employee(String fullName, String department, Double salary) {
        mFullName = fullName;
        mDepartment = department;
        mSalary = salary;
        mWorkedAt = "Learn with Vel Inc.";
    }

    public String getFullName() {
        return mFullName;
    }

    public String getDepartment() {
        return mDepartment;
    }

    public Double getSalary() {
        return mSalary;
    }

    public String getWorkedAt() {
        return mWorkedAt;
    }
}
