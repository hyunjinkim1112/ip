package mary.task;

//import mary.task.Task;

public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, boolean isDone, String from, String to) {
        super(description, false);
        this.isDone = isDone;
        this.from = from;
        this.to = to;
    }
    @Override
    public String getType() {
        return "E";
    }
    @Override
    public String toString() {
        return "[E]" + (isDone ? "[X] " : "[ ] ") + description + " (from: " + from + " to: " + to + ")";
    }
    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }
}
