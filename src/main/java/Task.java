public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description, Boolean isDone) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or [✗] symbols
    }

    public String getDescription() {
        return description; //return tick or X symbols
    }

    public void markAsDone() {
        this.isDone = true;

    }
}