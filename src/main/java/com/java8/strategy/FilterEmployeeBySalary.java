package com.java8.strategy;

/**
 * @Author wordpython
 * @Date 2020/2/23
 **/

public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary()>=9000;
    }
}
