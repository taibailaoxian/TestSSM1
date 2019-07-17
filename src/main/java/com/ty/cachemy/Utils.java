package com.ty.cachemy;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * 序列化和反序列化的工具类
 *
 * 为了保证线程安全， 使用了 threadLocal ,线程绑定机制  ，底层有个 threadlocalmap ,保存当前的对象
 *
 * 如果 当前线程没有 对象，就调用了 initivteEntry,,,
 */
public class Utils {

    //重写了 initialValue
    private static final ThreadLocal<Kryo> td = new ThreadLocal<Kryo>(){

        @Override
        protected Kryo initialValue() {
            return new Kryo();
        }
    };

    public byte[] xuliehua(Serializable obj) throws Exception{

        //注册  对象绑定到线程，所以直接从线程中拿就可以
        td.get().register(obj.getClass());
        //流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Output output = new Output();

        td.get().writeObject(output,obj);

        output.close();
        //返回
        return bos.toByteArray();
    }

    public <T>T fanxuliehua(Class<T> cls,byte[] array) throws Exception{

        ByteArrayInputStream bis = new ByteArrayInputStream(array);

        Input input = new Input(bis);

        T t = td.get().readObject(input, cls);

        input.close();
        return t;
    }
}
