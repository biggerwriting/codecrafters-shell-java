package command;

import java.io.File;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import static command.Pwd.pwd;

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
            } else if ("~".equals(dir)) {
                dir = HOME_DIR;
                return checkDir(dir);
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

        Thread thread = new Thread(()->{
            int loop = 0;
            while (true){
                System.out.println("thread execute loop="+loop);
                loop++;
                if(Thread.interrupted()){
                    System.out.println("interrupted");
                    break;
                }
            }
        });
        thread.start();
        thread.interrupt();

    }
}
