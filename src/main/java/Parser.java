/**
 * Object class that deals with making sense of the user command
 */
public class Parser {

    /**
     * Checks whether user input start with the word bye
     * and returns a boolean value
     */
    public static boolean startsWithBye(String userInput) {
        return (userInput.toLowerCase().startsWith("bye"));
    }

    /**
     * Checks whether user input start with the word list
     * and returns a boolean value
     */
    public boolean startsWithList(String userInput) {
        return (userInput.toLowerCase().startsWith("list"));
    }

    /**
     * Checks whether user input start with the word Done
     * and returns a boolean value
     */
    public boolean startsWithDone(String userInput) {
        return (userInput.toLowerCase().startsWith("done"));
    }

    /**
     * Checks whether user input start with the word Todo
     * and returns a boolean value
     */
    public static boolean startsWithTodo(String userInput) {
        return (userInput.toLowerCase().startsWith("todo"));
    }

    /**
     * Checks whether user input start with the word Event
     * and returns a boolean value
     */
    public boolean startsWithEvent(String userInput) {
        return (userInput.toLowerCase().startsWith("event"));
    }

    /**
     * Checks whether user input start with the word Deadline
     * and returns a boolean value
     */
    public static boolean startsWithDeadline(String userInput) {
        return (userInput.toLowerCase().startsWith("deadline"));
    }

    /**
     * Checks whether user input start with the word Delete
     * and returns a boolean value
     */
    public boolean startsWithDelete(String userInput) {
        return (userInput.toLowerCase().startsWith("delete"));
    }

    /**
     * Checks whether user input start with the word Find
     * and returns a boolean value
     */
    public boolean startsWithFind(String userInput) {
        return (userInput.toLowerCase().startsWith("find"));
    }

}
