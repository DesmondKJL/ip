/**
 * Enables user to create a Deadline task
 */

public class Deadline extends Task {

    protected String by;

    /**
     * Creates a deadline task with details specified by user
     *
     * @param description description of task that was input by user
     * @param by          deadline of task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Converts all details of the task into one full string
     */
    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + by + ")";
    }
}