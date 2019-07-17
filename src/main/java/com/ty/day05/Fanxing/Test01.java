package com.ty.day05.Fanxing;

public class Test01 {

    public static void main(String[] args) {

       // List<String> list = new ArrayList<Object>();  //f

       // List<Object> list = new ArrayList<String>();  //f

        //List<?> list = new ArrayList<String>();    //t

        //List<? extends Object> list = new ArrayList<Integer>();  //t
    }

}


interface Cache<K,V>{

}

class FifoCache<V> implements Cache<String,V>{

}


