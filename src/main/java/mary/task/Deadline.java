package mary.task;

//import mary.task.Task;

public class Deadline extends Task {
    protected String by;
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    @Override
    public String getType() {
        return "D";
    }
    @Override
    public String toString() {
        return super.toString()  + " (by:" + by + ")";
    }
}
