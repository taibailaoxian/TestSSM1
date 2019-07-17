package com.ty.day05.Fanxing;


// T = Type  用来约束 类中方法 的一些 类型
//泛型应用时相当于实参传给形参，但是实参必须为对象类型。

//接口泛型 并不是约束所有方法
interface Container<T>{

    void add(T t);
    T get(int t);
    int size();
}

abstract class AbstractContainer<T> implements Container<T>{

    private int size;

    //泛型类
    public abstract void add(T t);

    public abstract T get(int i);

    public int size(){
        return size;
    }
}

class ArrayContainer<T> extends AbstractContainer<T> {

    private Object[] array;

    public ArrayContainer() {
        this.array = new Object[16];
    }

    @Override
    public void add(T t) {

    }

    @Override
    public T get(int i) {
        return null;
    }
}
public class TestGeneric01 {

    public static void main(String[] args) {

    }
}
