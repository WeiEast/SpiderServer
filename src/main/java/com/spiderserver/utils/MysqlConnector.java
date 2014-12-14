package com.spiderserver.utils;

import com.spiderserver.po.SchemaInfo;
import com.spiderserver.po.Table;

import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by apoptoxin on 2014/11/27.
 */
public class MysqlConnector {
    private static Connection conn = null;
    private static PreparedStatement statement = null;
    private static String serverIP = "182.92.216.225";
    private static int port = 3306;
    private static String database = "spider";
    private static String url = "jdbc:mysql://"+serverIP+":"+port+"/"+database+"?zeroDateTimeBehavior=convertToNull";
    private static String userName = "root";
    private static String password = "UI7v51BfyFBh";
    private static Map<String, String> type;

    static {
        type = new HashMap<String, String>();
        type.put("int","int(11)");
        type.put("string","varchar(255)");
        type.put("date","date");
        type.put("double","double");
        type.put("float","float");
    }

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver" );
            conn = DriverManager.getConnection(url, userName, password);
        }
        catch (ClassNotFoundException cnfex ) {
            System.out.println("装载 JDBC/ODBC 驱动程序失败。" );
            cnfex.printStackTrace();
            return null;
        }
        catch ( SQLException sqlex ) {
            System.out.println( "无法连接数据库" );
            sqlex.printStackTrace();
            return null;
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            System.out.println("关闭数据库连接异常。");
            e.printStackTrace();
        }
    }

    public static void closeStatement(PreparedStatement statement) {
        try {
            if (statement != null)
                statement.close();
        } catch (Exception e) {
            System.out.println("关闭数据库连接异常。");
            e.printStackTrace();
        }
    }
    /**
     * Description: execute selection language
     * @return result set
     * Version: 1.0
     * 2013-8-1
     */
    private	static ResultSet selectSQL() {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    /**
     * Description: execute update language
     * @return success or not
     * Version: 1.0
     * 2013-8-1
     */
    private static boolean updateSQL() {
        if(conn == null){
            return false;
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }



    /**
     * Description: update function
     * @param table :create table
     * @return success or not
     * Version: 1.0
     * 2013-8-1
     */
    public static boolean createTable(Table table){
        conn = getConnection();
        String sql = new StringBuilder().append("create table if not exists `").append(table.getTableName()).append("`(").toString();
        for(String key: table.getCol().keySet()){
            sql += "`" + key + "`" + type.get(table.getCol().get(key)) + ",";
        }
        sql = sql+"primary key("+table.getKey()+"));";
        System.out.println(sql);
        try {
            statement = conn.prepareStatement(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        updateSQL();
        closeStatement(statement);
        closeConnection(conn);
        return true;
    }


    public static boolean insertSchema(SchemaInfo si){
        conn = getConnection();
        String sql = "insert into schemainfo(schemaname,strategy) values(?,?)";
        System.out.println(sql);
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,si.getSchemaName());
            statement.setString(2,si.getStrategy());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        updateSQL();
        closeStatement(statement);
        closeConnection(conn);
        return true;
    }

    public static void main(String[] args){
        Table table = new Table();
        table.setTableName("vip");
        table.getCol().put("col1","int");
        table.getCol().put("col2","string");
        table.getCol().put("col3","int");
        table.getCol().put("col4","double");
        table.setKey("col1,col2");
        createTable(table);
    }
}
