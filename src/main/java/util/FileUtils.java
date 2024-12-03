package util;

import java.io.File;
import java.nio.file.Files;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public class FileUtils {


    // 获取环境变量
    public static String[] paths = System.getenv("PATH").split(File.pathSeparator);

    public static String pathInclued(String command) {
        for (String dir : paths) {
            File file = new File(dir, command);
            if (file.exists() && Files.isRegularFile(file.toPath())) {
                return file.getPath();
            }
        }
        return null;
    }
}
