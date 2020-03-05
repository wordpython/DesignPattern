package com.java8.strategy;

/**
 * @Author wordpython
 * @Date 2020/2/22
 **/

public class FilterEmployeeByAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee t) {
        return t.getAge()>=35;
    }
}
