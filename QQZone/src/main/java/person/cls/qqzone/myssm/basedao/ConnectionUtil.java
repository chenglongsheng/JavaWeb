package person.cls.qqzone.myssm.basedao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description: 数据库连接工具
 * @author: CLS
 * @date: 2022-07-03-16:29
 * @version: 1.0
 */
public class ConnectionUtil {

    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PWD;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        InputStream is = ConnectionUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            DRIVER = properties.getProperty("jdbc.driver");
            URL = properties.getProperty("jdbc.url");
            USER = properties.getProperty("jdbc.user");
            PWD = properties.getProperty("jdbc.pwd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static void closeConnection() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;
        }
        if (!conn.isClosed()) {
            conn.close();
            threadLocal.set(null);
        }
    }

}
