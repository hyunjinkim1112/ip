package mary;

import mary.task.Deadline;
import mary.task.Event;
import mary.task.Task;
import mary.task.Todo;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TaskManager {
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";
    private ArrayList<Task> tasks;
    Storage storage;

    public TaskManager() throws FileNotFoundException {
        this.storage = new Storage("./data/mary.txt");
        this.tasks = storage.loadFromFile();
        if (tasks.isEmpty()) {
            System.out.println("No tasks loaded from the file.");
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println(LINE_SEPARATOR + "\nGot it. I've added this task:");
        System.out.println("\t" + task.toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");
        System.out.println(LINE_SEPARATOR);
    }

    public void removeTask(int index) {
        Task removedTask = tasks.remove(index);
        System.out.println(LINE_SEPARATOR + "\nGot it. I've removed this task:");
        System.out.println("\t" + removedTask.toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");
        System.out.println(LINE_SEPARATOR);

    }

    public void markTask(int index) {
        tasks.get(index).markAsDone();
        System.out.println(LINE_SEPARATOR + "\nNice! I've marked this task as done: ");
        System.out.println("\t" + tasks.get(index).toString());
        System.out.println(LINE_SEPARATOR);
    }

    public void unmarkTask(int index) {
        tasks.get(index).markAsNotDone();
        System.out.println(LINE_SEPARATOR + "\nNice! I've marked this task as not done yet: ");
        System.out.println("\t" + tasks.get(index).toString());
        System.out.println(LINE_SEPARATOR);
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println(LINE_SEPARATOR);
            System.out.println("No tasks available.");
            System.out.println(LINE_SEPARATOR);
            return;
        }
        System.out.println(LINE_SEPARATOR +"\nHere are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + tasks.get(i).toString());
        }
        System.out.println(LINE_SEPARATOR);
    }

    public void saveTasks() {
        storage.saveToFile(tasks);
    }
    public int getTaskCount() {
        return tasks.size();
    }
}
