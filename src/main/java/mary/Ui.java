/**
 * This represents a UI for the user input.
 */
package mary;

public class Ui {
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";
    /**
     * Prints hello message
     */
    public static void printHello() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm Mary");
        System.out.println("What can I do for you?");
        System.out.println(LINE_SEPARATOR);
        System.out.println("Enter command (todo, deadline, event, remove, list, mark, unmark, bye): ");
        System.out.println("[ Please follow the format below ]");
        System.out.println("- todo {short description}");
        System.out.println("- deadline {short description} /by {time}");
        System.out.println("- event {short description} /from {time} /to {time}");
        System.out.println("- list");
        System.out.println("- mark {number of the task}");
        System.out.println("- unmark {number of the task}");
        System.out.println("- find {a word in the task you are looking for}");
        System.out.println("- bye");
        System.out.println(LINE_SEPARATOR);

    }
    /**
     * Prints bye message
     */
    public static void printBye() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE_SEPARATOR);
    }
    /**
     * Prints error message
     */
    public static void printError(String message) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("OOPS! Your input is invalid.");
        System.out.println("[ Please refer to the error message ] \n- [error]: "+ message);
        System.out.println(LINE_SEPARATOR);
    }
    /**
     * Prints the error message when the file could not be loaded
     */
    public static void showLoadingError() {
        System.out.println(LINE_SEPARATOR);
        System.out.println("The file could not be loaded.");
        System.out.println(LINE_SEPARATOR);
    }

}
