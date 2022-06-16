package person.cls.thymeleaf.fruit.util;

/**
 * @description: String工具类
 * @author: CLS
 * @date: 2022-06-16-9:14
 * @version: 1.0
 */
public class StringUtils {

    public static boolean isEmpty(String string) {
        return !(string != null && !"".equals(string));
    }

}
