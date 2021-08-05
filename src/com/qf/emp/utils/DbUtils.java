package com.qf.emp.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.xml.transform.Result;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DbUtils {
    //获取数据库连接池
    private static DruidDataSource ds ;
    //事务控制
    private static final ThreadLocal<Connection>THREAD_LOCAL = new ThreadLocal<>() ;

    //静态代码块——做一些初始操作
    static {
        //
        Properties properties = new Properties() ;
        //获取一个字节输入流
        InputStream is = DbUtils.class.getResourceAsStream("/database.properties" ) ;

        try {
            //加载字节输入流
            properties.load(is);
            //创建数据库连接池
            ds =(DruidDataSource) DruidDataSourceFactory.createDataSource(properties) ; //有强转
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = THREAD_LOCAL.get() ;
        try {
            if( connection == null ){
                connection = ds.getConnection() ;
                THREAD_LOCAL.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection ;
    }

    //开启事务
    public static void begin(){
        Connection connection = null ;
        try {
            //获取连接
            connection = getConnection() ;
            //关闭自动提交
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }//这里没有 finally 啊 ，别写乱了
    }

    //提交事务
    public static void commit (){
        Connection connection = null ;
        try {
            //获取连接
            connection = getConnection() ;
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null) ;
        }
    }

    //回滚
    public static void rollback(){
        Connection connection = null ;
        try {
            //获取连接
            connection = getConnection() ;
            //回滚事务
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,null,null) ;
        }
    }

    //释放资源
    public static void closeAll(Connection connection , Statement statement , ResultSet resultSet){
        try {
            if(resultSet != null ){
                resultSet.close();
            }
            if(statement != null ){
                statement.close();
            }
            if(connection != null ){
                connection.close();
                THREAD_LOCAL.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
