package person.cls.qqzone.myssm.trans;

import person.cls.qqzone.myssm.basedao.ConnectionUtil;

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
    public void beginTransaction() throws SQLException {
        ConnectionUtil.getConnection().setAutoCommit(false);
    }

    /**
     * 提交事务
     */
    public void commitTransaction() throws SQLException {
        ConnectionUtil.getConnection().commit();
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction() throws SQLException {
        ConnectionUtil.getConnection().rollback();
    }

}
