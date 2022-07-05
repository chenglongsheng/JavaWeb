package person.cls.qqzone.myssm.exception;

/**
 * @description: DAO层运行时异常
 * @author: CLS
 * @date: 2022-07-05-7:48
 * @version: 1.0
 */
public class DAOException extends RuntimeException {

    public DAOException(String msg) {
        super(msg);
    }

}
