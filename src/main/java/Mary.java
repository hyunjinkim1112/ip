import java.util.Scanner;

public class Mary {
    public static final int MAX_TASKS = 100;
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        printHello();

        while (true) {
            String command = scanner.nextLine();
            manager.processCommand(command);
            if (command.equals("bye")) {
                printBye();
                break;
            }
        }
    }

    public static void printHello() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm Mary");
        System.out.println("What can I do for you?");
        System.out.println(LINE_SEPARATOR);
        System.out.print("Enter command (todo, deadline, event, list, mark, unmark, bye): ");
    }

    public static void printBye() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE_SEPARATOR);
    }
}

