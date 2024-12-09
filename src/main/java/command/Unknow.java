package command;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Unknow implements Strategy{
    @Override
    public String command(String input) {
        return input + ": command not found\n";
    }
}
