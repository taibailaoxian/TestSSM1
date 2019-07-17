package com.ty.day05.Xuliehua;

import java.io.*;

class Message implements Serializable {

    private static final long serialVersionUID = 9155512121727564075L;

    private int id;
    private String content;

    public Message() {
    }

    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}


public class TestXuLieHua {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

       Message message = new Message();
        message.setId(1);
        message.setContent("hello wcnm");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.data"));

        oos.writeObject(message);

        oos.close();
        System.out.println("序列化结束");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.data"));

        Message msg = (Message) ois.readObject();

        System.out.println(message == msg);
        System.out.println(msg);

    }
}
