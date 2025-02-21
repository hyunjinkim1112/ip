package mary;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mary {
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";

    public static void main(String[] args) throws InvalidCommandException, FileNotFoundException {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();

        printHello();

        while (true) {
            String command = scanner.nextLine();

            try {
                parser.processCommand(command, manager);
                if (command.equals("bye")) {
                    break;
                }
            } catch (InvalidCommandException e) {
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

