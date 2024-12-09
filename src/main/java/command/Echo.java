package command;

import java.util.Arrays;

import static util.StringUtils.parseCommand;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Echo implements Strategy {
    @Override
    public String command(String input) {
        String[] tokens = parseCommand(input);
        return String.join(" ", Arrays.stream(tokens, 1, tokens.length).toArray(String[]::new))+'\n';
    }

    public static void main(String[] args) {
        String input="echo \"script'hello'\\\\n'example\"";
        Echo echo = new Echo();
        String command = echo.command(input);
        System.out.println(command);
    }
}
