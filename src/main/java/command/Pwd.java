package command;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Pwd implements Strategy{
    public static String pwd = System.getProperty("user.dir");
    @Override
    public String command(String input) {
        return pwd;
    }
}
