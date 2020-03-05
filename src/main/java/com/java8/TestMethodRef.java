package com.java8;

/**
 * @Author wordpython
 * @Date 2020/2/24
 **/

import com.java8.strategy.Employee;
import org.junit.Test;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一：方法引用：若 Lambda 体中的内容有方法已经实现了，我们可以使用“方法引用”
 *      （可以理解为方法引用是 Lambda 表达式的另外一种表现形式）
 * 主要有三种语法格式：
 *  对象::实例方法名
 *  类::静态方法名
 *  类::实例方法名
 *
 * 注意：
 *  ① 使用方法引用的条件： Lambda体中调用方法的参数列表和返回值类型，要
 *      与函数式接口中抽象方法的参数列表和返回值类型保持一致！
 *      理解：如Supplier<String> sup=()->employee.getName();
 *          Lambda体中调用方法是：getName(),
 *          函数式接口是：Supplier
 *   ② 类::实例方法名 条件：
 *      若 Lambda 参数列表中的第一参数是 实例方法的调用者，而第二个参数是实例方法的参数时，
 *      可以使用ClassName::method
 *
 * 二：构造器引用：
 *  格式： ClassName::new
 *  注意：需要调用的构造器的参数列表要与函数式接口中的抽象方法的参数列表保持一致！
 *
 * 三：数组引用：
 *  格式：Type[]::new;
 *
 */
public class TestMethodRef {
    /*
    * 一：方法引用
    * */

    //对象::实例方法名
    @Test
    public void test1(){
        Consumer<String> con=(x)-> System.out.println(x);
        PrintStream ps=System.out;
        Consumer<String> con2=ps::println;
        con2.accept("abcdef");

        Employee employee = new Employee("李四",36,8080);
        Supplier<String> sup=()->employee.getName();
        String s = sup.get();

        Supplier<Integer> sup1=employee::getAge;
        Integer age = sup1.get();
    }
    //类::静态方法名
    @Test
    public void test2(){
        //普通方式
        Comparator<Integer> com=(x, y)->Integer.compare(x,y);
        //方法引用方式
        Comparator<Integer> com1=Integer::compareTo;
    }
    //类::实例方法名
    @Test
    public void test3(){
        BiPredicate<String,String> bp=(x,y) -> x.equals(y);
        BiPredicate<String,String> bp1=String::equals;
        //Supplier<Integer> sup1=Employee::getAge;//这样不行
    }

    /*
    * 二：构造器引用
    *
    * */
    @Test
    public void test4(){
        /*无参构造器*/
        Supplier<Employee> sup=() -> new Employee();
        //构造器引用方式
        Supplier<Employee> sup1=Employee::new;
        Employee emp=sup1.get();
        /*一个参数的构造器*/
        Function<Integer,Employee> fun=(x) -> new Employee(x);
        Function<Integer,Employee> fun1=Employee::new;
        Employee employee = fun1.apply(28);
        /*两个参数的构造器*/
        BiFunction<Integer,Integer,Employee> bf=Employee::new;
    }

    /*三：数组引用*/
    @Test
    public void test5(){
        Function<Integer,String[]> fun=x -> new String[x];
        String[] strs = fun.apply(10);

        Function<Integer,String[]> fun1=String[]::new;
        String[] strs2 = fun1.apply(10);
    }
}
