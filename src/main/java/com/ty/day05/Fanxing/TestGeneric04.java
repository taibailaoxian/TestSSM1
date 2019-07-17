package com.ty.day05.Fanxing;

import java.util.ArrayList;
import java.util.List;

class ContainerUtils{

    //泛型方法
    //1） 静态方法假如有泛型 肯定是 泛型方法
    //2） 泛型类和泛型接口 不作用域静态 方法
    //3） 泛型方法不一定是静态

    //方法参数和 返回值 如果有泛型 ，在 返回值左侧 + 泛型<T>
    public static <T>void sort(List<T> list){}

    public static void sortNumber(List<? extends Number> list){}

    public static <T>List<T> add(List<T> list,T... ts){

        for (T t:ts
             ) {
            list.add(t);
        }
        return list;
    }
}

public class TestGeneric04 {

    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList();
        List<String> list2 = new ArrayList();

        ContainerUtils.add(list1,200,330,100,600);
        ContainerUtils.add(list2,"bu","yao","a");

        System.out.println(list1);
        System.out.println(list2);

    }
}
