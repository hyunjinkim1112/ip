package mary.task;

import java.util.ArrayList;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }
    public void markAsNotDone() {
        this.isDone = false;
    }
    public boolean isDone() {
        return isDone;
    }
    public String getType() {
        return null;
    }
    public String getDescription() {
        return description;
    }
    public String toString() {
        return "[" + getType() + "][" + (isDone ? "X" : " ") + "] " + description;
    }
    public abstract String toFileFormat();
    public static Task fromFileFormat(String line) {
        Task task = null;
        String[] parts = line.split("\\|",2);

        switch (parts[0].trim()) {
        case ("T"):
            task = fromFileFormatTodo(parts[1]);
            break;
        case ("D"):
            task = fromFileFormatDeadline(parts[1]);
            break;
        case ("E"):
            task = fromFileFormatEvent(parts[1]);
            break;
        }
        return task;
    }

    private static Task fromFileFormatTodo(String line) {
        String[] parts = line.split("\\|");
        boolean isDone = parts[0].trim().equals("1") ? true : false;
        String description = parts[1].trim();
        return new Todo(description, isDone);
    }
    private static Task fromFileFormatDeadline(String line) {
        String[] parts = line.split("\\|");
        boolean isDone = parts[0].trim().equals("1") ? true : false;
        String description = parts[1].trim();
        String by = parts[2].trim();
        return new Deadline(description, isDone, by);
    }
    private static Task fromFileFormatEvent(String line) {
        String[] parts = line.split("\\|");
        boolean isDone = parts[0].trim().equals("1") ? true : false;
        String description = parts[1].trim();
        String from = parts[1].trim();
        String to = parts[2].trim();
        return new Event(description, isDone, from, to);
    }

//    public static Task fromFileFormat(String line) {
//        String[] parts = line.split(" | ");
//        String[] parts2 = parts[1].split(" | ");
//        String[] parts3;
//        String[] parts4;
//
//        String type = parts[0];
//        boolean isDone = parts2[0].equals("X")? true : false;;
//        String description;
//        Task task = null;
//
//        switch (type) {
//            case "T":
//                description = parts2[1];
//                task = new Todo(description, isDone);
//            case "D":
//                parts3 = parts2[1].split(" | ");
//                description = parts3[0];
//                String by = parts3[1];
//                task = new Deadline(description, by);
//            case "E":
//                parts3 = parts2[1].split(" | ");
//                parts4 = parts3[1].split(" | ");
//                description = parts3[0];
//                String from = parts4[0];
//                String to = parts4[1];
//                task = new Event(description, from, to);
//        }
//        return task;
//    };

}