package com.ty.day05.Xuliehua;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.*;

/**
 * 使用 hessian 框架 实现 相关对象的序列化和反序列化
 */
public class TestSerializable04 {

    public static void main(String[] args) throws Exception{

        Pay pay = new Pay(1,"cxk");

        SerializationUtil.doSerialization(pay,"hessian.data");

        pay = SerializationUtil.doDeserialization("hessian.data");


    }

}

class SerializationUtil {
    //反序列化
    @SuppressWarnings("unchecked")
    public static <T extends Serializable>T doDeserialization(String file) throws IOException, IOException {
        InputStream is = new FileInputStream(file);
        Hessian2Input in = new Hessian2Input(is);
        T t =(T)in.readObject();
        is.close();
        return t;
    }
    //序列化
    public static <T extends Serializable>void
    doSerialization(T obj,String file) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream(file);
        Hessian2Output out = new Hessian2Output(os);
        out.writeObject(obj);
        out.flush();
        os.close();
    }
}

class Pay implements Serializable{

    private static final long serialVersionUID = 7270171667811204554L;
    private Integer id;
    private String payType;

    public Pay() {
    }

    public Pay(Integer id, String payType) {
        this.id = id;
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "id=" + id +
                ", payType='" + payType + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}
