package com.ty.day05.Xuliehua;

import java.io.*;
import java.util.HashMap;


class SerializedCache{

    private HashMap<String,Object> cache = new HashMap();

    public void putObj(String key,Object value) {
        try {
            cache.put(key,serializable((Serializable) value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte[] serializable(Serializable obj) throws IOException {

        //构建字节数组输出流 ，内置了一个可扩容的字节数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //构建序列化对象 流
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        //序列化 到 缓存
        oos.writeObject(obj);
        //关资源
        oos.close();

        //为什么要返回数组？ 如果直接返回对象，再取出来的时候 ，依然是同一个对象
        return bos.toByteArray();
    }

    public Object get(String key){

        //获得 key的 byte数组
        byte[] bytes = (byte[]) cache.get(key);

        try {
            //调用方法
            return deserializable(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public Object deserializable(byte[] array) throws Exception{

        ByteArrayInputStream bis = new ByteArrayInputStream(array);

        ObjectInputStream ois = new ObjectInputStream(bis);

        Object obj = ois.readObject();

        ois.close();

        return obj;
    }
}
public class TestSerializable02 {

    public static void main(String[] args) {

        Message msg = new Message(1,"200 ccc");

        SerializedCache sc = new SerializedCache();

        sc.putObj("aa",msg);

        Message aa = (Message)sc.get("aa");

        System.out.println(aa == msg);

        System.out.println(msg.getId() +"    "+ msg.getContent());
        System.out.println(aa.getId() + "   "+aa.getContent());
    }
}
