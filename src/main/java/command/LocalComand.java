package command;

import java.io.File;
import java.io.IOException;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class LocalComand implements Strategy{
    String dir;

    public LocalComand(String dir) {
        this.dir = dir;
    }

    @Override
    public String command(String input) {
        try {
            String[] tokens = input.split(" ");
            tokens[0] = dir;

            System.out.println("local command input:"+input);
            System.out.println("local command dir:"+dir);
            Process process = Runtime.getRuntime().exec(tokens);
            process.getInputStream().transferTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
