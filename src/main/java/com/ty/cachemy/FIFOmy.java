package com.ty.cachemy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 利用 linkedList 和 hashmap 来实现一个先入先出的 结构
 *
 */
public class FIFOmy<K,V> implements Cache01<K,V> {

    private Map<K,V> caches = new HashMap<>();
    private LinkedList<K> list = new LinkedList<>();
    private int maxSize;

    public FIFOmy(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void putOnj(K key, V value) {

        //首先key放到 list的最后一个
        list.addLast(key);
        //检测是否超出容量 ，t就删除 第一个
        if (caches.size() > maxSize){

            K k = list.removeFirst();
            caches.remove(k);
        }
        //添加入map
        caches.put(key,value);

    }

    @Override
    public V getObj(K key) {
        return caches.get(key);
    }

}
