package com.ty.driverSourceTest;

import javax.sql.DataSource;

public class Test01 {

    public static void main(String[] args) {

        DataSource ds = new DriverSourceFactory().newInstence("c3p0");

        JdbcTamplate jt = new JdbcTamplate(ds);

        String sql = "delete from sys_logs where id =?";
        int rows = jt.deleteById(9,sql);

        System.out.println(rows);
    }
}
