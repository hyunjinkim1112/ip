package mary;

import java.util.Scanner;

public class Mary {
    public static final int MAX_TASKS = 100;
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";

    public static void main(String[] args) throws MaryException {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        printHello();

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("bye")) {
                printBye();
                break;
            }

            try {
                manager.processCommand(command);
            } catch (MaryException e) {
                printError(e.getMessage());
            }
        }
    }

    public static void printHello() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm Mary");
        System.out.println("What can I do for you?");
        System.out.println(LINE_SEPARATOR);
        System.out.println("Enter command (todo, deadline, event, list, mark, unmark, bye): ");
        System.out.println("[ Please follow the format below ]");
        System.out.println("- todo {short description}");
        System.out.println("- deadline {short description} /by {time}");
        System.out.println("- event {short description} /from {time} /to {time}");
        System.out.println("- list");
        System.out.println("- mark {number of the task}");
        System.out.println("- unmark {number of the task}");
        System.out.println("- bye");
        System.out.println(LINE_SEPARATOR);

    }

    public static void printBye() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE_SEPARATOR);
    }

    public static void printError(String message) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("OOPS! Your input is invalid.");
        System.out.println("[ Please refer to the error message ] \n- [error]: "+ message);
        System.out.println(LINE_SEPARATOR);
    }
}

