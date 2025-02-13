package mary.task;

public class Todo extends Task {
    public Todo(String description, boolean isDone) {
        super(description);
        this.isDone = isDone;
    }
    @Override
    public String getType() {
        return "T";
    }
    public String toString() {
        return super.toString();
    }
}
