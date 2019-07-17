package com.ty.driverSourceTest;
/**
 * 对数据库连接的一个类。 has a datasource 不是用来连接数据库，可以对数据库进行其他操作
 */

import javax.sql.DataSource;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTamplate {

    private DataSource ds;

    public JdbcTamplate() {
    }

    public JdbcTamplate(DataSource ds) {
        this.ds = ds;
    }

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    public int deleteById(int index,String sql){

        Connection conn = null;
        PreparedStatement pps = null;

        try {
            //获取连接池
            conn = ds.getConnection();
            //statement
            pps = conn.prepareStatement(sql);
            //sql 的 ？
            pps.setInt(1,index);
            //执行
            int i = pps.executeUpdate();
            //结果集
            return i;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //释放资源
            if (pps!=null) {
                try {
                    pps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return -1;
    }
}
