public class Parser {


    public static boolean startsWithBye(String userInput) {
        return (userInput.startsWith("bye"));
    }

    public boolean startsWithList(String userInput) {
        return (userInput.startsWith("list"));
    }

    public boolean startsWithDone(String userInput) {
        return (userInput.startsWith("done"));
    }

    public static boolean startsWithTodo(String userInput) {
        return (userInput.startsWith("todo"));
    }

    public boolean startsWithEvent(String userInput) {
        return (userInput.startsWith("event"));
    }

    public static boolean startsWithDeadline(String userInput) {
        return (userInput.startsWith("deadline"));
    }

    public boolean startsWithDelete(String userInput) {
        return (userInput.startsWith("delete"));
    }

    public boolean startsWithFind(String userInput) {
        return (userInput.startsWith("Find"));
    }

}
