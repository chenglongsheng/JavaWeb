package person.cls.qqzone.myssm.util;

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

    public static String substringFromPath(String path) {
        if (path.startsWith("/")) {
            String substring = path.substring(1);
            int lastIndexOfDot = substring.lastIndexOf(".do");
            return substring.substring(0, lastIndexOfDot);
        }
        return "error";
    }

}
