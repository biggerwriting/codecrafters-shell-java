import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("$ ");
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"exit 0".equalsIgnoreCase((input = scanner.nextLine()))) {
            String[] tokens = input.split(" ");
            if("echo".equalsIgnoreCase(tokens[0])){
                System.out.println(input.substring(5));
            }else {
                System.out.println(input + ": command not found");
            }
            System.out.print("$ ");
        }

    }
}
