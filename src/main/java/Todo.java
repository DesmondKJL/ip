public class Todo extends Task {

    /**
     * Creates a todo task with details specified by user
     *
     * @param description description of todo task that was input by user
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts all details of the task into one full string
     */
    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}