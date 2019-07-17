package com.ty.cachemy;

public interface Cache01<K,V> {

    void putOnj(K key,V value);

    V getObj(K key);
}
