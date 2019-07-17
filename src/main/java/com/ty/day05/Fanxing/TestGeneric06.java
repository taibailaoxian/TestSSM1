package com.ty.day05.Fanxing;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric06 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList();

        list.add(100);
        list.add(200);

        //将list集合转化成一个整数数组

        Integer[] array = list.toArray(new Integer[9]);

        System.out.println(array);
    }

    public static void doMethod(Integer[] array) {

    }
}
