package com.ty.cache;
public interface Cache<K,V> {
     /***
            * 向容器中放数据
      * @param key
      * @param value
      */
	 void putObject(K key, V value);
	 /**
	    * 从容器区数据
	  * @param key
	  * @return
	  */
	 V getObject(K key);
	 
}





