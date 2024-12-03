import java.util.Scanner;
import java.util.Set;

public class Main {
    public static final Set<String> builtin = Set.of("echo", "exit", "type");

    public static void main(String[] args) throws Exception {
        System.out.print("$ ");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"exit 0".equalsIgnoreCase((input = scanner.nextLine()))) {
            String[] tokens = input.split(" ");
            if ("echo".equalsIgnoreCase(tokens[0])) {
                System.out.println(input.substring(5));
            } else if ("type".equalsIgnoreCase(tokens[0])) {
                if (builtin.contains(tokens[1])) {
                    System.out.println(tokens[1] + " is a shell builtin");
                } else {
                    System.out.println(tokens[1] + ": not found");
                }
            } else {
                System.out.println(input + ": command not found");
            }
            System.out.print("$ ");
        }

    }
}
