package com.springmvc.entity;


class A{
    static {
        System.out.println("class a stattic{}");
    }
}
public class TestClassObject03 {

    //使用classloder 加载classA
    public static void main(String[] args) throws ClassNotFoundException {

        /* new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        }.loadClass("com.springmvc.entity.A");*/

        ClassLoader loader = ClassLoader.getSystemClassLoader();

        loader.loadClass("com.springmvc.entity.A");

    }
}

