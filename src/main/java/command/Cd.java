package command;

import java.io.File;
import java.nio.file.Files;

import static command.Pwd.pwd;

/**
 * $ cd /does_not_exist
 * cd: /does_not_exist: No such file or directory
 *
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Cd implements Strategy {
    @Override
    public String command(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length > 1) {
            String dir = tokens[1];
            if (dir.startsWith(File.separator)) {
                return checkDir(dir);
            } else if (dir.startsWith("." + File.separator)) {
                dir = pwd + dir.substring(1);
                // System.out.println("相对路径dir:" + dir);
                return checkDir(dir);
            } else if (dir.startsWith(".." + File.separator)) {
                String[] split = dir.split("\\.\\.");
                File moveTo = new File(pwd);

                for (int i = 0; i < split.length; i++) {
                    //System.out.println(i + " " + split[i]);
                    String current = split[i];
                    if (File.separator.equals(current)) {
                        moveTo = moveTo.getParentFile();
                    } else {
                        moveTo = new File(moveTo.getAbsolutePath() + current);
                    }
                }
                return checkDir(moveTo.getAbsolutePath());
            }
        }
        return null;
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

    public static void main(String[] args) {
        String str = "../../../a/b/c";
        String[] split = str.split("\\.\\.");
        for (int i = 0; i < split.length; i++) {
            System.out.println(i + " " + split[i]);

        }
    }
}
