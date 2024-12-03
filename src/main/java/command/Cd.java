package command;

import java.io.File;
import java.nio.file.Files;

/**
 * $ cd /does_not_exist
 * cd: /does_not_exist: No such file or directory
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class Cd implements Strategy{
    @Override
    public String command(String input) {

        String[] tokens = input.split(" ");
        if(tokens.length>1){
            String dir = tokens[1];
            File file = new File(dir);
            if(file.exists() && Files.isDirectory(file.toPath())){
                Pwd.pwd = file.getAbsolutePath();
                return null;
            }else {
                return String.format("cd: %s: No such file or directory", dir);
            }
        }
        return null;
    }
}
