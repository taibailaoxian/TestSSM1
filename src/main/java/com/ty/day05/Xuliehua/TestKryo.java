package com.ty.day05.Xuliehua;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/**
 * 用 kryo 来序列化 反序列化
 */
public class TestKryo {

    public static void main(String[] args) throws Exception{

        Pay pay = new Pay(11,"Klose");

        byte[] bytes = KryoUtils.serializable(pay);
        Pay pay1 = KryoUtils.deserializable(bytes, Pay.class);

        System.out.println(pay1);
    }
}

/**
 *  ThreadLocal 提供了一种 线程绑定机制，能够将 某个对象绑定到当前线程，
 *      也可以从当前线程获取绑定的对象。
 *  常用的方法
 *      get() 获取当前线程绑定的对象
 *      set(value) 绑定对象到当前线程
 *      remove()
 */
class KryoUtils{

    //Kryo 是线程不安全的，所以采用下面的方式保证线程安全
    private static final ThreadLocal<Kryo> td = new ThreadLocal<Kryo>(){

        //ThreadLocal是线程安全的
        /* 外界通过 ThreadLocal 的 get 方法去 获取 绑定的对象的时候，加入
        *   当前的线程没有， 就会创建一份 Kryo绑定到 当前线程
        *
        * 其实 每个Thread之中 都有一个 ThreadLocalMap ，他的 key = ThreadLocal ,V = 当前泛型的对象。
        * 如果 当前线程没有 kryo,就new一个然后放到 ThreadLocalMap 之中去5
        * */
        @Override
        protected Kryo initialValue() {
            return new Kryo();
        }
    };

    //序列化
    static byte[] serializable(Serializable obj){

        td.get().register(obj.getClass());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Output output = new
                Output(baos);

        td.get().writeObject(output,obj);

        output.close();

        return baos.toByteArray();
    }

    //反序列化
    static <T>T deserializable(byte[] bytes,Class<T> cls){

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);

        Input input = new Input(bais);
        T t1 = td.get().readObject(input,cls);

        input.close();

        return t1;
    }



}