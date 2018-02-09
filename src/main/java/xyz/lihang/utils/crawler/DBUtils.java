package xyz.lihang.utils.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author : lihang1329@gmail.com
 * @since : 2018/2/9
 */
public class DBUtils {

    private static String url = "jdbc:mysql://127.0.0.1:3306/linuxidc?characterEncoding=UTF8";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String name = "root";
    private static String password = "admin";
    private static Logger logger = LoggerFactory.getLogger(DBUtils.class);


    private static Connection connection = null;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null){
            connection = DriverManager.getConnection(url,name,password);
            connection.setAutoCommit(false);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection!=null)
            connection.close();
    }

    public static void save(Base base) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement= getConnection().prepareStatement("INSERT INTO file (`name`,`url`,`type`,`path`,`size`,`uploadtime`) VALUES (?,?,?,?,?,?)");

            preparedStatement.setString(1, base.name);
            preparedStatement.setString(2, base.path);
            preparedStatement.setString(3, base instanceof Folder ?"文件夹" : "文件");
            preparedStatement.setString(4, base.decoderBase64);
            preparedStatement.setString(5, base.size);
            preparedStatement.setString(6, base.createTime);

            int i = preparedStatement.executeUpdate();
            if(i>0)
                logger.info("save db success");
            else
                logger.info("save db error");
            connection.commit();
        }catch (Exception e){
            logger.error("save db exception ::: " + e.getMessage());
            e.printStackTrace();
        }finally {
            if (preparedStatement != null)
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }


}
