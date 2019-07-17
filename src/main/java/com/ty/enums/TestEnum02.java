package com.ty.enums;

import java.util.EnumMap;

enum Sex{
    MALE("男"),
    FEMALE("女");

    //枚举类中的构造方法必须是私有的
    private String name;
    Sex(String name) {
        this.name = name;
    }

    public void doPrint(){
        System.out.println(name);
    }
}

//会员难度
class Member{

    private Sex sex = Sex.FEMALE;

    public Sex getSex(){
        return sex;
    }
}

public class TestEnum02 {

    public static void main(String[] args) {

        //调用枚举类中的方法
        Sex.MALE.doPrint();

        Member m1 = new Member();

        m1.getSex().doPrint();

        //所有枚举类 默认继承 Enum
        System.out.println(m1.getSex() instanceof Enum);

        EnumMap<Sex,String> enumMap = new EnumMap<Sex, String>(Sex.class);

        enumMap.put(Sex.MALE,"男男");
        enumMap.put(Sex.FEMALE,"女女");

        System.out.println(enumMap);

    }
}
