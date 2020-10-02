public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Creates a task with specified description
     *
     * @param description description of task based on user input
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets status icon of the task
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or [✗] symbols
    }

    /**
     * Gets only the description of the task
     */
    public String getDescription() {
        return description; //return tick or X symbols
    }

    /**
     * Converts all attributes including desription, date if applicable and status icon, of the task into one full string
     */
    public String toString() {
        return getStatusIcon() + " " + getDescription();
    }

    /**
     * Marks the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }
}