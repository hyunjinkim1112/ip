import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

public class TaskManager {
    public static final int MAX_TASKS = 100;
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";

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
