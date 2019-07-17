package com.ty.day05.Fanxing;

import java.util.List;

/**
 * 认识泛型方法
 */

class DefaultSqlSession implements MybatisSession{

    @Override
    public <T> T selectList(String sql) {
        return null;
    }

    @Override
    public <T> T getMapper(Class<T> T) {
        return null;
    }

}


interface MybatisSession{

    //泛型方法： 在方法返回值左侧有<泛型>
                // 返回值的类型可以不是 T

    // 提高了方法返回值的灵活性
    <T>T selectList(String sql);

    public <T>T getMapper(Class<T> T);

}
public class TestGeneric03 {

    public static void main(String[] args) {

        DefaultSqlSession session = new DefaultSqlSession();

        String sql = "select * from user";
        List<String> list = session.selectList(sql);
    }
}
