import command.Echo;
import command.Type;
import command.Unknow;

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
            if ("echo".equalsIgnoreCase(tokens[0])) {
                processer = new Processer(new Echo());
            } else if ("type".equalsIgnoreCase(tokens[0])) {
                processer = new Processer(new Type());
            } else {
                processer = new Processer(new Unknow());
            }
            result = processer.processCommand(input);
            System.out.println(result);
            System.out.print("$ ");
        }

    }
}
