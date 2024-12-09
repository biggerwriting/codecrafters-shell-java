package command;

import util.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.Set;

import static util.StringUtils.parseCommand;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Type implements Strategy {
    public static final Set<String> builtin = Set.of("echo", "exit", "type", "pwd", "cd");

    @Override
    public String command(String input) {
        String[] tokens = parseCommand(input);

        String command = tokens[1];
        if (builtin.contains(command)) {
            return command + " is a shell builtin\n";
        }
        String dir = FileUtils.pathInclued(command);
        if (dir != null) {
            return String.format("%s is %s\n", command, dir);
        } else {
            return command + ": not found\n";
        }
    }
}
