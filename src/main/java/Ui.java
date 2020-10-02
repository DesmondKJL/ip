public class Ui {
    protected static final String TODO_ERROR = "☹ OOPS!!! The description of a todo cannot be empty.";
    protected static final String DEADLINE_DESCRIPTION_ERROR = "☹ OOPS!!! The description of a deadline cannot be empty.";
    protected static final String EVENT_DESCRIPTION_ERROR = "☹ OOPS!!! The description of a event cannot be empty.";
    protected static final String GENERAL_ERROR = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";

    public static void displayWelcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n");
        System.out.println("What can I do for you?\n");
    }

    public static void displayByeMessage() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    public static void displayTodoErrorMessage() {
        System.out.println(TODO_ERROR);
    }

    public static void displayDeadlineErrorMessage() {
        System.out.println(DEADLINE_DESCRIPTION_ERROR);
    }

    public static void displayGeneralErrorMessage() {
        System.out.println(GENERAL_ERROR);
    }
    public static void displayEventErrorMessage() {
        System.out.println(EVENT_DESCRIPTION_ERROR);
    }



}
