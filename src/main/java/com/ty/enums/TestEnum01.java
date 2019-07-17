package com.ty.enums;

class Goods{

    private Gender gender = Gender.MALE;

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gender=" + gender +
                '}';
    }
}

//定义枚举类
enum  Gender{

    MALE,
    FEMALE,
    NONE;

    //如上三个值是对象实例，在类加载的时候创建

}

public class TestEnum01 {

    public static void main(String[] args) {

        Goods g1 = new Goods();

        String gender = "MALE";

        g1.setGender(Gender.valueOf(gender));

        System.out.println(g1);

    }
}
