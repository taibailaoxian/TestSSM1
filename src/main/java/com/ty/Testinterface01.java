package com.ty;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Testinterface01 {

    public static void main(String[] args) throws Exception {

        //getDruidConntion();

        getComboPooledDataSource();
    }

    private static DataSource getHikari() throws Exception{

        HikariDataSource hds = new HikariDataSource();

        hds.setDriverClassName("com.mysql.jdbc.Driver");
        hds.setJdbcUrl("jdbc:mysql:///yonghedb");
        hds.setUsername("root");
        hds.setPassword("root");

        return hds;

    }

    public static DataSource getComboPooledDataSource () throws Exception{

        ComboPooledDataSource cpds = new ComboPooledDataSource();

        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql:///yonghedb");
        cpds.setUser("root");
        cpds.setPassword("root");

        System.out.println(cpds);

        return cpds;

    }

    public static DataSource getDruidConntion() throws SQLException {
        DruidDataSource dds = new DruidDataSource();

        dds.setDriverClassName("com.mysql.jdbc.Driver");

        dds.setUrl("jdbc:mysql:///yonghedb");
        dds.setUsername("root");
        dds.setPassword("root");

        Connection conn = dds.getConnection();
        System.out.println(conn);

        return dds;
    }

}
