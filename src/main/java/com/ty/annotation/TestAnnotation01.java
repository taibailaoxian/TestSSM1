package com.ty.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/*
    自定义注解
 */
@Retention(RetentionPolicy.RUNTIME)//描述注解何时有效
@Target(ElementType.TYPE)//描述注解可以修饰哪些对象(类，方法 等)
@interface Entrty{
    //元数据(描述数据的数据)
    String value() default ""; //注解中的属性定义

}

//@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@interface ID{

    String value() default "";
}

@Entrty("cnm")
class Goods{

    @ID("gis")
    private Integer id;
}

public class TestAnnotation01 {

    public static void main(String[] args) throws Exception {

        //Bean Pool   ,第一次创建在池中创建，第二次在池中寻找，有的话就拿出来用  单例的一种思路
        Map<String,Object> singletonMap = new HashMap();

        //通过反射获取goods对象的 注解
        Class<?> aClass = Class.forName("com.ty.annotation.Goods");

        /*Annotation[] annotations = aClass.getAnnotations();

        for (Annotation a:annotations
             ) {
            System.out.println(a);
        }*/

        Entrty entrty = aClass.getAnnotation(Entrty.class);


        String value = entrty != null ? entrty.value() : null;
        System.out.println(value);

        if (entrty!=null) {
            System.out.println("将此类对象交给spring" + entrty);
            singletonMap.put("Entry",entrty);

        }

        //Entrty daE = aClass.getDeclaredAnnotation(Entrty.class);

        //获取 goods属性上的注解

        Field id = aClass.getDeclaredField("id");

        ID idAnnotation = id.getAnnotation(ID.class);

        if (idAnnotation!=null){

            String s = idAnnotation.value();
            System.out.println(s);

            singletonMap.put("ID",idAnnotation);
        }


        System.out.println(singletonMap);


    }
}
