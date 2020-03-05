package com.java8.strategy;


import org.junit.Test;

import java.util.*;

/**
 * @Author wordpython
 * @Date 2020/2/21
 **/

public class TestLambda {
    public void test1(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> integers = new TreeSet<>(comparator);
    }

    @Test
    public void test2(){
         Comparator<Integer> comparator= (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> integers = new TreeSet<>(comparator);

    }

    List<Employee> employees=Arrays.asList(
            new Employee("张三",45,9999),
            new Employee("李四",25,7766),
            new Employee("王五",19,5555),
            new Employee("黄六",55,12111),
            new Employee("芳七",30,8676)
    );

    //需求：获取当前公司中员工年龄大于35岁的员工信息
    @Test
    public void test3(){
        List<Employee> employees = filterEmployees(this.employees);
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
    public List<Employee> filterEmployees(List<Employee> list){
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp:list){
            if (emp.getAge()>=35){//变化的代码
                emps.add(emp);
            }
        }
        return emps;
    }

    //需求：获取当前公司中工资大于9000的员工信息
    public List<Employee> filterEmployees2(List<Employee> list){
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee emp:list){
            if (emp.getSalary()>=9000){//变化的代码
                emps.add(emp);
            }
        }
        return emps;
    }

    /**
     * 优化方式一：优化上面的需求代码：使用策略模式
     *
     * */
    public List<Employee> filterEmployee(List<Employee> list,MyPredicate<Employee> mp){
        ArrayList<Employee> emps = new ArrayList<>();
        for (Employee employee:list){
            if (mp.test(employee)){//修改这里即可
                emps.add(employee);
            }
        }
        return emps;
    }
    //需求：获取当前公司中员工年龄大于35岁的员工信息
    @Test
    public void test5(){
        List<Employee> employees = filterEmployee(this.employees,new FilterEmployeeByAge());
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
    //需求：获取当前公司中工资大于9000的员工信息
    @Test
    public void test6(){
        List<Employee> employees = filterEmployee(this.employees,new FilterEmployeeBySalary());
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
    /**
     * 优化方式二：匿名内部类,在优化方式一基础上再优化
     */
    @Test
    public void test7(){
        List<Employee> em = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary()>=9000;
            }
        });
        for(Employee employee:em){
            System.out.println(employee);
        }

    }
    /**
     * 优化方式三：Lambda表达式,在优化方式二基础上再优化
     */
    @Test
    public void test8(){
        List<Employee> list = filterEmployee(employees,(employee)->employee.getSalary()>=9000);
        list.forEach(System.out::println);//遍历输出
    }
    /**
     * 优化方式四：Stream API
     */
    @Test
    public void test9(){
        employees.stream()
                .filter((e)->e.getSalary()>=9000)
                .forEach(System.out::println);
    }
}
