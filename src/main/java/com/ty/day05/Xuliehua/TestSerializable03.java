package com.ty.day05.Xuliehua;

import java.io.*;
import java.util.Base64;

/**
 * 加密 解密
 */
public class TestSerializable03 {

    public static void doMethod(){

        String pwd = "wsnd";

        //encoder 是加密对象
        Base64.Encoder encoder = Base64.getEncoder();

        String s = encoder.encodeToString(pwd.getBytes());
        // 加密
        System.out.println(s);

        //decoder  解密对象
        Base64.Decoder decoder = Base64.getDecoder();

        byte[] bytes = decoder.decode(s);
        pwd = new String(bytes);

        System.out.println("pwd "+pwd);

    }

    public static void main(String[] args) throws Exception {

       // doMethod();

        //执行序列化
        SysLog sl = new SysLog(1,"klose");

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("sys.data")
        );

        oos.writeObject(sl);

        oos.close();


        //解密

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("sys.data")
        );

        SysLog o = (SysLog) ois.readObject();

        ois.close();

        System.out.println(o);

    }

}

class SysLog implements Serializable {

    private int id;
    private String createUser;

    public SysLog() {
    }

    public SysLog(int id, String createUser) {
        this.id = id;
        this.createUser = createUser;
    }

    //序列化  ，对象流在执行 时会默认调用这个方法
    private void writeObject(ObjectOutputStream oos) throws Exception{

        Base64.Encoder encoder = Base64.getEncoder();

        createUser = encoder.encodeToString(createUser.getBytes());

        oos.defaultWriteObject();
    }

    //反序列化
    private void readObject(ObjectInputStream ois) throws Exception{

        //先反序列化，再解密
        ois.defaultReadObject();

        Base64.Decoder decoder = Base64.getDecoder();

        byte[] bytes = decoder.decode(createUser);
        createUser = new String(bytes);

    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", createUser='" + createUser + '\'' +
                '}';
    }
}