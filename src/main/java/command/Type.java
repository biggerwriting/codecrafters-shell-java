package command;

import java.io.File;
import java.nio.file.Files;
import java.util.Set;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Type implements Strategy {
    public static final Set<String> builtin = Set.of("echo", "exit", "type");

    // 获取环境变量
    public static String[] paths = System.getenv("PATH").split(File.pathSeparator);

    @Override
    public String command(String input) {
        String[] tokens = input.split(" ");
        
        String command = tokens[1];
        if (builtin.contains(command)) {
            return command + " is a shell builtin";
        }
        String dir = pathInclued(command);
        if (dir != null) {
            return String.format("%s is %s%n", command, dir);
        } else {
            return command + ": not found";
        }
    }

    private String pathInclued(String command) {
        for (String dir : paths) {
            File file = new File(dir, command);
            if (file.exists() && Files.isRegularFile(file.toPath())) {
                return file.getPath();
            }
        }
        return null;
    }
}
