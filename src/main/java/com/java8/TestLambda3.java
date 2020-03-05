package com.java8;

/**
 * @Author wordpython
 * @Date 2020/2/24
 **/

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置的四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 *      void accept(T t);
 *
 * Supplier<T> : 供给型接口
 *      T get();
 *
 * Function<T,R> : 函数型接口
 *      R apply(T t);
 *
 * Predicate<T> : 断言型接口
 *      boolean test(T t);
 *
 */
public class TestLambda3 {
    //Consumer<T> : 消费型接口
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
    @Test
    public void test1(){
        happy(1000,x-> System.out.println("wordpython购买鬼刀很多东西花费"+x+"元"));
    }

    //Supplier<T> : 供给型接口
    //需求：产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num,Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int a=sup.get();
            list.add(a);
        }
        return list;
    }
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int)(Math.random()*100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    //Function<T,R> : 函数型接口
    //需求：处理字符串
    public String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }
    @Test
    public void test3(){
        String s = strHandler("  我就看 我不说话\t\t\t", x -> x.trim());
        System.out.println(s);
    }

    //Predicate<T> : 断言型接口
    //需求：将满足条件的字符串，放入聚合中
    public List<String> filterString(List<String> list, Predicate<String> pre){
        List<String> objects = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                objects.add(s);
            }
        }
        return objects;
    }
    @Test
    public void test4(){
        List<String> strList = Arrays.asList("Hello", "wordpython", "ydl", "cyda", "Lambda");
        List<String> list=filterString(strList,s->s.length()>3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
