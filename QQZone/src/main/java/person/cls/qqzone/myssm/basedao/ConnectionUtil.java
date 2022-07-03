package person.cls.qqzone.myssm.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description: 数据库连接工具
 * @author: CLS
 * @date: 2022-07-03-16:29
 * @version: 1.0
 */
public class ConnectionUtil {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/fruitdb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static final String USER = "root";
    public static final String PWD = "123456";

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection createConnection() {
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = createConnection();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }

}
