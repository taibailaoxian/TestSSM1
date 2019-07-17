package com.springmvc.entity;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 二分
 */
public class Test01 {


    public static void main(String[] args) {

        System.out.println("请输入 key");
        int key = new Scanner(System.in).nextInt();

        int[] list = new int[10];
        for (int i = 0; i < 10; i++) {
            list[i] = (int) (Math.random()*100);
        }

        Arrays.sort(list);

        System.out.println(Arrays.toString(list));

        boolean isFlage = erfen(key,list);

        System.out.println(isFlage);
    }

    private static boolean erfen(int key,int[] arrs) {

        int left = 0,right = arrs.length-1,mid = 0;

        while (left<right){

            mid = (right + left)/2;

        if (arrs[mid]> key)
                right = mid-1;
            else if (arrs[mid] < key)
                left = mid +1;
            else
                return true;
        }

        return false;
    }
}
