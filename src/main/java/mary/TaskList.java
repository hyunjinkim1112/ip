/**
 * This class represents a tasklist which contains all the methods for each command.
 */

package mary;
import mary.task.Task;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TaskList {
    public static final String LINE_SEPARATOR = "____________________________________________________________ ";
    private ArrayList<Task> tasks;

    /**
     * Constructor for TaskList
     */
    public TaskList(ArrayList<Task> tasks) throws FileNotFoundException {
        this.tasks = tasks;
        if (tasks.isEmpty()) {
            System.out.println("No tasks loaded from the file.");
        }
    }
    /**
     * Adds a new task to the list
     */
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println(LINE_SEPARATOR + "\nGot it. I've added this task:");
        System.out.println("\t" + task.toString());
        System.out.println("Now you have " + tasks.size() + " task(s) in the list.");
        System.out.println(LINE_SEPARATOR);
    }
    /**
     * Removes a new task from the list 
     */
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

    public void findTask(String keyword) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Here are the matching tasks in your list.");
        int index = 1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).toString().contains(keyword)) {
                System.out.println("\t" + index + ". " + tasks.get(i).toString());
                index++;
            }
        }
        System.out.println(LINE_SEPARATOR);
    }
    public ArrayList<Task> getTasks() {
        return tasks;
    }
    public int getTaskCount() {
        return tasks.size();
    }
}
