package command;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static command.Cd.getAbsPath;
import static util.StringUtils.parseCommand;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/9
 */
public class Cat implements Strategy {
    @Override
    public String command(String input) {
        String[] tokens = parseCommand(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < tokens.length; i++) {
            String filepath = tokens[i];
            String absPath = getAbsPath(filepath);
            try (InputStream inputStream = new FileInputStream(absPath)) {

                byte[] array = new byte[1024];
                int readLength = 0;
                while (0 != inputStream.read(array)) {
                    sb.append(new String(array, 0, readLength));
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        return sb.toString();
    }
}
