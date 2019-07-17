package com.ty.enums;

import com.ty.cache.Cache;

enum CacheType{

    LRU,
    FIFO,
    LAJI;
}

class CacheFactory<K,V>{

    public Cache newCache(CacheType cacheType){

        switch (cacheType){

            case LRU:return null;
            //...
            default:
                break;
        }
        return null;
    }

}

public class Test03 {
}
