package com.springmvc.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 通过组合的思想  利用 linkedList 和 hashMap 实现一个 先进先出的 数据结构
 */

public class TestCompose {

    public static void main(String[] args) {

        LMCache lc = new LMCache(3);

        lc.put("A",100);
        lc.put("D",400);
        lc.put("B",200);
        lc.put("C",300);

        System.out.println(lc);
    }
}

class LMCache{

    private int size;
    //map 和 list  用new的方式 也是一种注入
    private Map<String,Object> map = new HashMap();

    private LinkedList<String> list = new LinkedList();

    public LMCache(int size){
        this.size = size;
    }

    public void put(String key,Object value){

        //1, 首先key 放在 linkedlist中 ，用来 保存 顺序
        list.addLast(key);

        //2. 如果长度超过size 就删掉
        if (list.size() >=size){
            String keys = list.removeFirst();
            map.remove(keys);
        }

        //3. put数据进入 map
        map.put(key,value);
    }
}