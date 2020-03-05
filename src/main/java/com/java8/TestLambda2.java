package com.java8;


import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @Author wordpython
 * @Date 2020/2/21
 **/

/**
 * 格式一：无参数，无返回值
 * () -> System.out.println("Hello Lambda!");
 * <p>
 * 格式二：有一个参数（小括号可以省略），无返回值
 * (x) -> System.out.println(x);
 * x -> System.out.println(x);
 * <p>
 * 格式三：Lambda表达式的参数列表的类型可以省略不写，
 * 因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
 * Comparator<Integer> com = (Integer x, Integer y) -> Integer.compare(x, y);
 * <p>
 * 格式四：有两个以上参数，有返回值，并且Lambda体中有多条语句
 * Comparator<Integer> com=(x,y)->{
 * System.out.println("函数式接口");
 * return Integer.compare(x,y);
 * };
 * <p>
 * 格式五：Lambda体中只有一条语句，return和大括号可以省略
 * Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
 */
public class TestLambda2 {
    @Test
    public void test1() {
        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("鬼刀超好看");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (Integer x, Integer y) -> {
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test4() {
        int i = 1;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
            }
        };
        Runnable r2 = ()-> System.out.println(i);
    }
}
