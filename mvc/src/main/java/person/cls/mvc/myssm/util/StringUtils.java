package person.cls.mvc.myssm.util;

/**
 * @description: String工具类
 * @author: CLS
 * @date: 2022-06-25-9:25
 * @version: 1.0
 */
public class StringUtils {

    public static boolean isEmpty(String string) {
        return !(string != null && !"".equals(string));
    }

    public static boolean isNotEmpty(String string) {
        return (string != null && !"".equals(string));
    }

}
