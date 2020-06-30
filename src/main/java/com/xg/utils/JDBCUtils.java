package com.xg.utils;

import java.sql.*;

/**
 * 创作时间：2020/6/12 10:03
 * 作者：李增强
 */
public class JDBCUtils {
    /**
     * 连接数据的四个  url、driver、username、passWord
     */
    /**
     * 在类里面直接new对象，这叫饿汉式单例模式，
     * 用的时候，在new对象，是懒汉式单例模式
     */
    private static JDBCUtils jDBCUtils;


    String driver="oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "scott";
    String password = "scott";

    /**
     * 加载驱动
     */
    private JDBCUtils(){
        try {
            Class.forName(driver);
        }catch (Exception e){
        }
    }

    /**
     * 单例的方式来加载获取连接
     * 1、构造器私有化
     * 2、创建一个静态的公有，返回值是类本身的方法
     */

    /**
     * 懒汉式设计模式，有线程安全问题，怎么解决，加锁
     * 1、在方法上加锁，把整个方法锁住，这样的效率严重下降，不建议使用
     * synchronized加锁，不建议使用，这个方法只能一个一个通过
     */
    public static JDBCUtils getInstance(){
        /**
         * 单例模式加锁
         */
        if(jDBCUtils==null){
            synchronized(JDBCUtils.class){
                if(jDBCUtils==null){
                    jDBCUtils  = new JDBCUtils();
                }
            }
        }
        return jDBCUtils;
    }

    /**
     * 获取连接
     */

    public Connection getCon(){

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 通用的增删改的方法
     * @param sql
     * @param objs
     * @return
     */
    public int executeUpdate(String sql,Object... objs){
        Connection conn = null;
        PreparedStatement ps = null;
        int num = 0;//受影响行数
        try {
            conn = getCon();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i+1, objs[i]);
            }
            num = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            closeJDBC(conn, ps,null);
        }
        return num;
    }

    public void closeJDBC(Connection conn, PreparedStatement ps, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            }catch (Exception e){

            }

        }
        if(ps!=null){
            try {
                ps.close();
            }catch (Exception e){

            }

        }
        if(conn!=null){
            try {
                conn.close();
            }catch (Exception e){

            }

        }
    }

}
