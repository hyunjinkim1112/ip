package mary.task;

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
        String[] parts = line.split("\\|");

        switch (parts[0].trim()) {
        case "T":
            task = fromFileFormatTodo(parts);
            break;
        case "D":
            task = fromFileFormatDeadline(parts);
            break;
        case "E":
            task = fromFileFormatEvent(parts);
            break;
        default:
            throw new IllegalArgumentException("Unknown task type: " + parts[0]);
        }
        return task;
    }

    private static Task fromFileFormatTodo(String[] parts) {
        boolean isDone = parts[1].trim().equals("1");
        String description = parts[2].trim();
        return new Todo(description, isDone);
    }

    private static Task fromFileFormatDeadline(String[] parts) {
        boolean isDone = parts[1].trim().equals("1");
        String description = parts[2].trim();
        String by = parts[3].trim();
        return new Deadline(description, isDone, by);
    }

    private static Task fromFileFormatEvent(String[] parts) {
        boolean isDone = parts[1].trim().equals("1");
        String description = parts[2].trim();
        String from = parts[3].trim();
        String to = parts[4].trim();
        return new Event(description, isDone, from, to);
    }

}