import java.util.Scanner;

public class Mary {

    public static final int MAX_TASKS = 100;
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";

    public static void printHello() {
        String hello = LINE_SEPARATOR + "\n"
                + "Hello! I'm Mary \n"
                + "What can I do for you? \n"
                + LINE_SEPARATOR + "\n";
        System.out.println(hello);
    }

    public static void printBye() {
        String bye = LINE_SEPARATOR + "\n"
                + "Bye. Hope to see you again soon! \n"
                + LINE_SEPARATOR + "\n";
        System.out.println(bye);
    }

    public static void printList(Task[] taskList, int numTasks) {
        System.out.println(LINE_SEPARATOR + "\n");
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < numTasks; i++) {
            Task task = taskList[i];
            System.out.println((i + 1) + ".[" + task.getStatusIcon() + "] " + task.getDescription());
        }
        System.out.println(LINE_SEPARATOR + "\n");
    }

    public static void echoCommand(String command) {
        System.out.println(LINE_SEPARATOR + "\n"
                + "added: " + command + "\n"
                + LINE_SEPARATOR + "\n");
    }

    public static void addToList(Task[] taskList, int numTasks, String command) {
        Task task = new Task(command);
        taskList[numTasks] = task;
    }

    public static String[] parseCommand(String command) {
        return command.split(" ", 2);
    }

    public static void markTask(Task[] taskList, int taskIndex) {
        taskList[taskIndex].setDone(true);
    }

    public static void printMark(Task[] taskList, int taskIndex) {
        System.out.println(LINE_SEPARATOR + "\n" +
                "Nice! I've marked this task as done: " + "\n" +
                "\t [" + taskList[taskIndex].getStatusIcon() + "] " + taskList[taskIndex].getDescription() + "\n" +
                LINE_SEPARATOR + "\n");
    }

    public static void unmarkTask(Task[] taskList, int taskIndex) {
        taskList[taskIndex].setDone(false);
    }

    public static void printUnmark(Task[] taskList, int taskIndex) {
        System.out.println(LINE_SEPARATOR + "\n" +
                "OK, I've marked this task as not done yet: " + "\n" +
                "\t [" + taskList[taskIndex].getStatusIcon() + "] " + taskList[taskIndex].getDescription() + "\n" +
                LINE_SEPARATOR + "\n");
    }

    public static void main(String[] args) {
        Task[] taskList = new Task[MAX_TASKS];
        int numTasks = 0;

        printHello();

        while (true) {
            String fullCommand = new Scanner(System.in).nextLine();
            String[] partsCommand = parseCommand(fullCommand);
            String command = partsCommand[0];
            int taskIndex;

            switch (command) {
            case "list":
                printList(taskList, numTasks);
                continue;
            case "bye":
                printBye();
                return;
            case "mark":
                taskIndex = Integer.parseInt(partsCommand[1]) - 1;
                markTask(taskList, taskIndex);
                printMark(taskList, taskIndex);
                continue;
            case "unmark":
                taskIndex = Integer.parseInt(partsCommand[1]) - 1;
                unmarkTask(taskList, taskIndex);
                printUnmark(taskList, taskIndex);
                continue;
            default:
                addToList(taskList, numTasks, fullCommand);
                numTasks++;
                echoCommand(fullCommand);
                continue;
            }
        }
    }
}

