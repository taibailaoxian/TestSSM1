package com.ty.testJackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *  <dependency>
 *    <groupId>com.fasterxml.jackson.core</groupId>
 *    <artifactId>jackson-databind</artifactId>
 *    <version>2.9.8</version>
 *   </dependency>
 *
 *   6.	基于jackson库将一个java对象转换为json串.(必须要做)
 */
public class Test {

    public static void main(String[] args) throws Exception {

        Goods goods = new Goods(1,"klose");

        //构建jackson的对象转换器
        ObjectMapper mapper = new ObjectMapper();

        //将对象转化为 json格式的字符串 (序列化)
        String s1 = mapper.writeValueAsString(goods);

        System.out.println(s1);
        //将字符串转化为 json 格式的对象 (反序列化)
        Goods goods1 = mapper.readValue(s1, Goods.class);

        System.out.println(goods1);
        System.out.println(goods1 == goods);
    }

    // 使用第三方库 将对象转换成json 格式的字符串
    static String doJsonFrom(){


        return null;
    }
}


class Goods{

    private int id;
    private String name;

    public Goods() {
    }

    public Goods(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}