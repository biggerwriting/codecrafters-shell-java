package command;

import java.io.File;
import java.nio.file.Files;

import static command.Pwd.pwd;
import static util.StringUtils.parseCommand;

/**
 * $ cd /does_not_exist
 * cd: /does_not_exist: No such file or directory
 *
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Cd implements Strategy {
    public static final String HOME_DIR = System.getenv("HOME");

    @Override
    public String command(String input) {
        String[] tokens = parseCommand(input);
        if (tokens.length > 1) {
            String dir = tokens[1];
            dir = getAbsPath(dir);
            return checkDir(dir);
        }
        return null;
    }

    public static String getAbsPath(String dir) {
        if (dir.startsWith(File.separator)) {
        } else if (dir.startsWith(".." + File.separator)) {
            String[] split = dir.split("\\.\\.");
            File moveTo = new File(pwd);
            for (int i = 0; i < split.length; i++) {
                String current = split[i];
                if (File.separator.equals(current)) {
                    moveTo = moveTo.getParentFile();
                } else {
                    moveTo = new File(moveTo.getAbsolutePath() + current);
                }
            }
            dir = moveTo.getAbsolutePath();
        } else if ("~".equals(dir)) {
            dir = HOME_DIR;
        } else if (dir.startsWith("." + File.separator)) {
            dir = pwd + dir.substring(1);
        }else {
            dir = pwd + dir;
        }
        return dir;
    }

    private static String checkDir(String dir) {
        File file = new File(dir);
        if (file.exists() && Files.isDirectory(file.toPath())) {
            //System.out.println("pwd is :" + pwd);
            pwd = file.getAbsolutePath();
            return null;
        } else {
            return String.format("cd: %s: No such file or directory", dir);
        }
    }

}
