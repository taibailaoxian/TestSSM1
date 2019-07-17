package com.ty.driverSourceTest;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 创建 不同版本数据库连接池的 工厂
 */
public class DriverSourceFactory {

    public DataSource newInstence(String brand){

        if ("druid".equals(brand))
            return getDruid();
        else if ("c3p0".equals(brand))
            return getC3p0();
        else if ("hikari".equals(brand))
            return getHikari();

        return null;
    }

    private static DataSource getC3p0(){

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {

            cpds.setDriverClass("com.mysql.jdbc.Driver");
            cpds.setJdbcUrl("jdbc:mysql:///jtsys");
            cpds.setUser("root");
            cpds.setPassword("root");

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return  cpds;
    }

    private static DataSource getDruid(){

        DruidDataSource dds = new DruidDataSource();

        dds.setDriverClassName("com.mysql.jdbc.Driver");
        dds.setUrl("jdbc:mysql:///jtsys");
        dds.setUsername("root");
        dds.setPassword("root");

        return dds;
    }

    private static DataSource getHikari(){

        HikariDataSource hds = new HikariDataSource();

        hds.setDriverClassName("com.mysql.jdbc.Driver");
        hds.setJdbcUrl("jdbc:mysql:///jtsys");
        hds.setUsername("root");
        hds.setPassword("root");

        return hds;
    }
}
