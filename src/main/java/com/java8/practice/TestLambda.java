package com.java8.practice;

import com.java8.strategy.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author wordpython
 * @Date 2020/2/24
 **/

public class TestLambda {
    List<Employee> employees= Arrays.asList(
            new Employee("张三",45,9999),
            new Employee("李四",25,7766),
            new Employee("王五",19,5555),
            new Employee("黄六",55,12111),
            new Employee("芳七",30,8676)
    );
    @Test
    public void test1(){
        Collections.sort(employees,(x,y)->{
            if(x.getAge()==y.getAge()){
                return x.getName().compareTo(y.getName());
            }else {
                return -Integer.compare(x.getAge(),y.getAge());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    //需求：用于处理字符串
    public String strHandler(String str,MyFunction mf){
        return mf.getValue(str);
    }
    @Test
    public void test2(){
        String s = strHandler("\t\t\t 鬼ad刀超de好看  ", String::toUpperCase);
//        String s = strHandler("\t\t\t 鬼ad刀超de好看  ", str -> str.toUpperCase());
        System.out.println(s);
        String s1 = strHandler("t\\t 鬼ad刀超de好看  \"", str -> str.substring(2,6));
        System.out.println(s1);
    }

    //需求：对于两个long型数据进行处理
    public void longHandler(Long l1,Long l2,MyFunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));;
    }
    @Test
    public void test3(){
        longHandler(100L,200L,(x,y)->x+y);
        longHandler(100L,200L,(x,y)->x*y);

    }
}
