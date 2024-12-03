package command;

import util.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.util.Set;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Type implements Strategy {
    public static final Set<String> builtin = Set.of("echo", "exit", "type", "pwd");

    @Override
    public String command(String input) {
        String[] tokens = input.split(" ");

        String command = tokens[1];
        if (builtin.contains(command)) {
            return command + " is a shell builtin";
        }
        String dir = FileUtils.pathInclued(command);
        if (dir != null) {
            return String.format("%s is %s", command, dir);
        } else {
            return command + ": not found";
        }
    }
}
