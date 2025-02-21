package mary.task;

public class Todo extends Task {
    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }
    @Override
    public String getType() {
        return "T";
    }
    @Override
    public String toString() {
        return "[T]" + (isDone ? "[X] " : "[ ] ") + description;
    }
    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }
}
