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
            System.out.println(LINE_SEPARATOR);
            System.out.println("No tasks available.");
            System.out.println(LINE_SEPARATOR);
            return;
        }
        System.out.println(LINE_SEPARATOR +"\nHere are the tasks in your list:");
        for (int i = 0; i < numTasks; i++) {
            System.out.println("\t" + (i + 1) + ". " + taskList[i].toString());
        }
        System.out.println(LINE_SEPARATOR);
    }

    public void processCommand(String input) throws MaryException {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String description;
        int taskIdx;

        if (command.equals("list")) {
            listTasks();
            return;
        }

        try {
            description = parts[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw MaryException.emptyDescription();
        }
        switch (command) {
        case "todo":
            addTask(new Todo(description, false));
            break;
        case "deadline":
            try {
                String[] by = description.split("/by");
                String task = by[0];
                String deadline = by[1];
                addTask(new Deadline(task, deadline));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw MaryException.invalidDescription("please write in this format: deadline {name of the event} /by {time}");
            }
            break;
        case "event":
            String task;
            String schedule;
            String startTime;
            String endTime;

            try {
                String[] from = description.split("/from");
                task = from[0];
                schedule = from[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw MaryException.invalidDescription("please write in this format: event {name of the event} /from {time} /to {time}");
            }
            try {
                String[] to = schedule.split("/to");
                startTime = to[0];
                endTime = to[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw MaryException.invalidDescription("please write in this format: event {name of the event} /from {time} /to {time}");
            }
            addTask(new Event(task, startTime, endTime));
            break;
        case "mark":
            try {
                taskIdx = Integer.parseInt(parts[1]) - 1;
            } catch (NumberFormatException e) {
                throw MaryException.invalidDescription("please write in this format: mark {number of the task e.g. 1}");
            }
            if (taskIdx < 0 || taskIdx >= numTasks) {
                throw MaryException.invalidDescription("please write in this format: mark {number of the task e.g. 1}");
            }
            markTask(taskIdx);
            break;
        case "unmark":
            try {
                taskIdx = Integer.parseInt(parts[1]) - 1;
            } catch (NumberFormatException e) {
                throw MaryException.invalidDescription("please write in this format: unmark {number of the task e.g. 1}");
            }
            if (taskIdx < 0 || taskIdx >= numTasks) {
                throw MaryException.invalidDescription("please write in this format: unmark {number of the task e.g. 1}");
            }
            unmarkTask(taskIdx);
            break;
        default:
            throw MaryException.invalidCommand(command);
        }
    }
}
