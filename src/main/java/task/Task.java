package task;

public class Task {
    protected String description;
    protected boolean isDone = false;

    public Task(String description) {
        this.description = description;
    }
    public void setIsDone(boolean done) {
        this.isDone = true;
    }
    public String getType() {
        return null;
    }
    public String toString() {
        return "[" + getType() + "][" + (isDone ? "X" : " ") + "] " + description;
    }
}