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
        return String.join(" ", Arrays.stream(tokens, 1, tokens.length).toArray(String[]::new));
    }
}
