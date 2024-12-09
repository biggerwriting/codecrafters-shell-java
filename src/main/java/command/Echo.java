package command;

import static util.StringUtils.parseCommand;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Echo implements Strategy {
    @Override
    public String command(String input) {
        String[] tokens = parseCommand(input);
        return tokens[1];
    }
}
