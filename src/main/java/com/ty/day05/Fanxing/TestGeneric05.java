package com.ty.day05.Fanxing;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 尝试利用 反射 向下 集合之中 添加 整数
 * List<String> list=new ArrayList<String>()
 *
 *泛型类型擦除   ===  泛型在运行时会变成 object
 */
public class TestGeneric05 {

    public static void main(String[] args) throws Exception {

        List<String> list=new ArrayList<String>();

        list.add("a");

        //list.add(100);

        //1. 获取 反射入口 (字节码对象)
        //2. 基于 字节码 对象 获取 类中的 add方法 对象
        //3. 通过反射执行 add 方法，将100 写入集合
        //4. 输出

        Class<? extends List> lclass = list.getClass();
        //Class<?> lclass = Class.forName("java.util.ArrayList");

        Method adds = lclass.getMethod("add", int.class,Object.class);

        adds.invoke(list,0,200);

        System.out.println(list);

        String indexs = list.get(0);

        //反射放进去 的 反射取出

        Method gets = lclass.getDeclaredMethod("get", int.class);

        Object in = gets.invoke(list, 0);

        System.out.println(in);
    }
}


class TestRefact{

    public static void main(String[] args) {

        List<String> list = new ArrayList();

        Class<? extends List> aClass = list.getClass();

        Method[] methods = aClass.getDeclaredMethods();

        for (Method m:methods
             ) {
            System.out.println(m);
        }
    }
}