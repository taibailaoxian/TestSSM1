package com.ty.day05.Refence;

import java.lang.ref.SoftReference;

public class TestRefences01 {

    public static void main(String[] args) {

        //1. msg 变量为强引用  (直接引用)
        Message msg = new Message(1,"roony");

        //,msg = null;
        //手动启用GC
        System.gc();

        // 2 软引用 ：SoftReference
        SoftReference<Message> msg2 = new SoftReference(new Message(2, "klose"));
        System.out.println(msg2.get());

        //手动启用GC
        System.gc();

    }
}


class Message{

    private int id;
    private String cont;

    public Message(int id, String cont) {
        this.id = id;
        this.cont = cont;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", cont='" + cont + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("msg  will die");
    }
}
