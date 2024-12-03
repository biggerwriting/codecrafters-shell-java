package command;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Echo implements Strategy {
    @Override
    public String command(String commands) {
        return commands.substring(5);
    }
}
