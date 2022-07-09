package person.cls.myssm.trans;

import person.cls.myssm.basedao.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description: 事务管理
 * @author: CLS
 * @date: 2022-07-03-16:23
 * @version: 1.0
 */
public class TransactionManager {

    /**
     * 开启事务
     */
    public static void beginTransaction() throws SQLException {
        ConnectionUtil.getConnection().setAutoCommit(false);
    }

    /**
     * 提交事务
     */
    public static void commitTransaction() throws SQLException {
        Connection connection = ConnectionUtil.getConnection();
        connection.commit();
        ConnectionUtil.closeConnection();
    }

    /**
     * 回滚事务
     */
    public static void rollbackTransaction() throws SQLException {
        ConnectionUtil.getConnection().rollback();
        ConnectionUtil.closeConnection();
    }

}
