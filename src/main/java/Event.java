public class Event extends Task {

    protected String at;

    /**
     * Creates an event task with details specified by user
     *
     * @param description description of task that was input by user
     * @param at          date of event
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }


    /**
     * Converts all attributes of the task into one full string
     */
    @Override
    public String toString() {
        return "[E] " + super.toString() + " (at: " + at + ")";
    }
}