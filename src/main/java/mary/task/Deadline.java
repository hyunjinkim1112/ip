package mary.task;

//import mary.task.Task;

public class Deadline extends Task {
    protected String by;
    public Deadline(String description, boolean isDone, String by) {
        super(description, false);
        this.isDone = isDone;
        this.by = by;
    }
    @Override
    public String getType() {
        return "D";
    }
    @Override
    public String toString() {
        return "[D]" + (isDone ? "[X] " : "[ ] ") + description + " (by: " + by + ")";
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }
}
