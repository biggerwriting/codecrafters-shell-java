import command.*;
import util.FileUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.print("$ ");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"exit 0".equalsIgnoreCase((input = scanner.nextLine()))) {
            Processer processer;
            String result;
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String dir = FileUtils.pathInclued(command);
            if ("echo".equalsIgnoreCase(command)) {
                processer = new Processer(new Echo());
            } else if ("type".equalsIgnoreCase(command)) {
                processer = new Processer(new Type());
            } else if ("pwd".equalsIgnoreCase(command)) {
                processer = new Processer(new Pwd());
            }  else if ("cd".equalsIgnoreCase(command)) {
                processer = new Processer(new Cd());
            } else if (dir != null) {
                processer = new Processer(new LocalComand(dir));
            } else {
                processer = new Processer(new Unknow());
            }
            result = processer.processCommand(input);
            if (result != null) {
                System.out.println(result);
            }
            System.out.print("$ ");
        }

    }
}
