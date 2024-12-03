package command;

import com.sun.tools.javac.Main;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Pwd implements Strategy{
    @Override
    public String command(String input) {
        return System.getProperty("user.dir");
    }
}
