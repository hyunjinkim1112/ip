package mary;
import java.util.ArrayList;
import mary.task.Deadline;
import mary.task.Event;
import mary.task.Task;
import mary.task.Todo;

public class TaskManager {
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";

    ArrayList<Task> tasks = new ArrayList<>();

    public void processCommand(String input) throws MaryException {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String description;
        int taskIdx;

        if (command.equals("list")) {
            printList();
            return;
        }

        try {
            description = parts[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw MaryException.emptyDescription();
        }
        switch (command) {
        case "todo":
            Task newTask = new Todo(description, false);
            tasks.add(newTask);
            printAddMsg(tasks.size() - 1);
            break;

        case "delete":
            try {
                taskIdx = Integer.parseInt(parts[1]) - 1;
            } catch (NumberFormatException e) {
                throw MaryException.invalidDescription("please write in this format: delete {number of the task e.g. 1}");
            }
            tasks.remove(taskIdx);
            printDeleteMsg(taskIdx);
            break;
        case "deadline":
            try {
                String[] by = description.split("/by");
                String task = by[0];
                String deadline = by[1];
                tasks.add(new Deadline(task, deadline));
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
            tasks.add(new Event(task, startTime, endTime));
            break;
        case "mark":
            try {
                taskIdx = Integer.parseInt(parts[1]) - 1;
            } catch (NumberFormatException e) {
                throw MaryException.invalidDescription("please write in this format: mark {number of the task e.g. 1}");
            }
            if (taskIdx < 0 || taskIdx >= tasks.size()) {
                throw MaryException.invalidDescription("please write in this format: mark {number of the task e.g. 1}");
            }
            tasks.get(taskIdx).setIsDone(true);
            printMarkMsg(taskIdx);
            break;
        case "unmark":
            try {
                taskIdx = Integer.parseInt(parts[1]) - 1;
            } catch (NumberFormatException e) {
                throw MaryException.invalidDescription("please write in this format: unmark {number of the task e.g. 1}");
            }
            if (taskIdx < 0 || taskIdx >= tasks.size()) {
                throw MaryException.invalidDescription("please write in this format: unmark {number of the task e.g. 1}");
            }
            tasks.get(taskIdx).setIsDone(false);
            printUnmarkMsg(taskIdx);
            break;
        default:
            throw MaryException.invalidCommand(command);
        }
    }

    public void printAddMsg(int taskIdx) {
        System.out.println(LINE_SEPARATOR + "\nGot it. I've added this task:");
        System.out.println("\t" + tasks.get(taskIdx).toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");
        System.out.println(LINE_SEPARATOR);
    }

    public void printDeleteMsg(int taskIdx) {
        System.out.println(LINE_SEPARATOR + "\nNoted. I've removed this task:");
        System.out.println("\t" + tasks.get(taskIdx).toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");
        System.out.println(LINE_SEPARATOR);
    }

    public void printMarkMsg(int taskIdx) {
        System.out.println(LINE_SEPARATOR + "\nNice! I've marked this task as done: ");
        System.out.println("\t" + tasks.get(taskIdx).toString());
        System.out.println(LINE_SEPARATOR);
    }

    public void printUnmarkMsg(int taskIdx) {
        System.out.println(LINE_SEPARATOR + "\nNice! I've marked this task as not done yet: ");
        System.out.println("\t" + tasks.get(taskIdx).toString());
        System.out.println(LINE_SEPARATOR);
    }

    public void printList() {
        if (tasks.isEmpty()) {
            System.out.println(LINE_SEPARATOR);
            System.out.println("No tasks available.");
            System.out.println(LINE_SEPARATOR);
            return;
        }
        System.out.println(LINE_SEPARATOR +"\nHere are the tasks in your list:");
        for (Task task : tasks) {
            System.out.println(task.toString());
        }
        System.out.println(LINE_SEPARATOR);
    }
}
