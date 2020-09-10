import java.util.Scanner;


public class Duke {

    protected static final String TODO_ERROR = "☹ OOPS!!! The description of a todo cannot be empty.";
    protected static final String DEADLINE_DESCRIPTION_ERROR = "☹ OOPS!!! The description of a deadline cannot be empty.";
    protected static final String EVENT_DESCRIPTION_ERROR = "☹ OOPS!!! The description of a event cannot be empty.";
    protected static final String DEADLINE_DATE_ERROR = "☹ OOPS!!! Please add a date for this deadline task";
    protected static final String EVENT_DATE_ERROR = "☹ OOPS!!! Please add a date for this event task";
    protected static final String DONE_WRONG_NUMBER_ERROR = "☹ OOPS!!! Please provide a valid task number";
    protected static final String DONE_ERROR = "☹ OOPS!!! Please input the command correctly (e.g done 1)";
    protected static final String GENERAL_ERROR = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";

    public static void main(String[] args) throws DukeExceptions{
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n");
        System.out.println("What can I do for you?\n");
        Scanner in = new Scanner(System.in);

        //user inputs into line string
        String line;

        //creating list of tasks
        Task[] list;
        list = new Task[100];

        //variables for list
        int itemNumber = 1;
        int itemDone = 0;
        int numeration = 1;

        //variables to check command
        boolean startsWithBye = false;
        boolean startsWithList = false;
        boolean startsWithDone = false;
        boolean startsWithTodo = false;
        boolean startsWithDeadline = false;
        boolean startsWithEvent = false;
        boolean isDone = false;

        //other variables
        int indexOfBackslash = 0;
        String deadlineDate;


        while (!startsWithBye) {

            //waiting for user input
            line = in.nextLine();

            //checking command
            startsWithBye = line.startsWith("bye");
            startsWithList = line.startsWith("list");
            startsWithDone = line.startsWith("done");
            startsWithDeadline = line.startsWith("deadline");
            startsWithTodo = line.startsWith("todo");
            startsWithEvent = line.startsWith("event");

            try {

                if (startsWithList) { //list command given
                    System.out.println("Here are the tasks in your list:");
                    for (numeration = 1; numeration < itemNumber; numeration++) {
                        System.out.println(numeration + "." + list[numeration].toString());
                    }

                } else if (startsWithDone) { //done command given
                    itemDone = Integer.parseInt(line.substring(5));
                    list[itemDone].markAsDone();
                    System.out.println("Nice! I've marked this task as done:\n    \u2713 " + list[itemDone].getDescription());

                } else if (startsWithDeadline) { //deadline command given
                    indexOfBackslash = line.indexOf("/");
                    deadlineDate = line.substring(indexOfBackslash + 4);
                    line = line.substring(9, indexOfBackslash - 1);
                    list[itemNumber] = new Deadline(line, deadlineDate, isDone);
                    System.out.println("Got it. I've added this task:\n  " + list[itemNumber].toString() + "\nNow you have " + itemNumber + " tasks in the list.");
                    itemNumber++;

                } else if (startsWithTodo) { //todo command given
                    list[itemNumber] = new Todo(line.substring(5), isDone);
                    System.out.println("Got it. I've added this task:\n  " + list[itemNumber].toString() + "\nNow you have " + itemNumber + " tasks in the list.");
                    itemNumber++;

                } else if (startsWithEvent) { //event command given
                    indexOfBackslash = line.indexOf("/");
                    deadlineDate = line.substring(indexOfBackslash + 4);
                    line = line.substring(6, indexOfBackslash - 1);
                    list[itemNumber] = new Event(line, deadlineDate, isDone);
                    System.out.println("Got it. I've added this task:\n  " + list[itemNumber].toString() + "\nNow you have " + itemNumber + " tasks in the list.");
                    itemNumber++;
                } else{
                    throw new DukeExceptions();
                }


            } catch (IndexOutOfBoundsException e) {
                if (startsWithTodo) {
                    System.out.println(TODO_ERROR);
                } else if (startsWithEvent) {
                    System.out.println(EVENT_DESCRIPTION_ERROR);
                }else if (startsWithDeadline) {
                    System.out.println(DEADLINE_DESCRIPTION_ERROR);
                }
            } catch (NullPointerException e) {
                System.out.println(DONE_WRONG_NUMBER_ERROR);
            } catch (NumberFormatException e) {
                System.out.println(DONE_ERROR);
            } catch (DukeExceptions e){
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }

        System.out.println("Bye. Hope to see you again soon!\n");

    }
}
