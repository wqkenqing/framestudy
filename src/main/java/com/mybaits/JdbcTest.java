package com.mybaits;

import org.junit.Test;

import java.sql.*;

/**
 * Created by wqkenqing on 2017/3/14.
 */
public class JdbcTest {
    Connection con = null;

    @Test
    public void init() throws ClassNotFoundException, SQLException {

        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://wqkenqing.mysql.rds.aliyuncs.com:3306/blogadmin";
        String user = "wqkenqing";
        String pwd = "125323wQ";
        ResultSet resultSet;
        con = DriverManager.getConnection(url, user, pwd);
        String sql = "select * from blog_article";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("name" + resultSet.getString("name"));
        }
        //建立连接
        // 获取Preparestatement


    }
}
