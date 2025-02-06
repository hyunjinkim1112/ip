import java.util.Scanner;

public class Mary {
    public static final int MAX_TASKS = 100;
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";

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

    public static class TaskManager {
        Task[] taskList = new Task[MAX_TASKS];
        int numTasks = 0;

        public void addTask(Task task) {
            taskList[numTasks] = task;
            numTasks++;
            System.out.println(LINE_SEPARATOR + "\nGot it. I've added this task:");
            System.out.println("\t" + task.toString());
            System.out.println("Now you have " + numTasks + " task(s) in the list.");
            System.out.println(LINE_SEPARATOR);
        }

        public void markTask(int taskIdx) {
            taskList[taskIdx].setIsDone(true);
            System.out.println(LINE_SEPARATOR + "\nNice! I've marked this task as done: ");
            System.out.println("\t" + taskList[taskIdx].toString());
            System.out.println(LINE_SEPARATOR);
        }

        public void unmarkTask(int taskIdx) {
            taskList[taskIdx].setIsDone(false);
            System.out.println(LINE_SEPARATOR + "\nNice! I've marked this task as not done yet: ");
            System.out.println("\t" + taskList[taskIdx].toString());
            System.out.println(LINE_SEPARATOR);
        }

        public void listTasks() {
            if (numTasks == 0) {
                System.out.println("No tasks available.");
                return;
            }
            System.out.println(LINE_SEPARATOR +"\nHere are the tasks in your list:");
            for (int i = 0; i < numTasks; i++) {
                System.out.println("\t" + (i + 1) + ". " + taskList[i].toString());
            }
            System.out.println(LINE_SEPARATOR);
        }

        public void processCommand(String input) {
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            int taskIdx;

            switch (command) {
            case "list":
                listTasks();
                break;
            case "todo":
                addTask(new Todo(parts[1], false));
                break;
            case "deadline":
                String[] by = parts[1].split("/by");
                addTask(new Deadline(by[0], by[1]));
                break;
            case "event":
                String[] from = parts[1].split("/from");
                String[] to = from[1].split("/to");
                addTask(new Event(from[0], to[0], to[1]));
                break;
            case "mark":
                taskIdx = Integer.parseInt(parts[1]) - 1;
                markTask(taskIdx);
                break;
            case "unmark":
                taskIdx = Integer.parseInt(parts[1]) - 1;
                unmarkTask(taskIdx);
                break;
            }
        }
    }

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
}

