package mary;

import mary.task.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Storage {
    private static String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public static void saveToFile(ArrayList<Task> tasks) {
        try {
            System.out.println("Saving " + tasks.size() + " tasks to " + filePath);
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Ensure the directory exists

            FileWriter fw = new FileWriter(file);
            for (Task task : tasks) {
                fw.write(task.toFileFormat() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    public ArrayList<Task> loadFromFile() throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        ArrayList<Task> tasks = new ArrayList<Task>();
        if (!f.exists()) {
            System.out.println("File not found. Returning an empty task list.");
            return tasks; // Return an empty list if the file doesn't exist
        }


        try (Scanner s = new Scanner(f)) { // Use try-with-resources
            while (s.hasNextLine()) {
                String line = s.nextLine();
                Task task = Task.fromFileFormat(line); // Convert line to Task
                if (task != null) {
                    tasks.add(task);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }

}
