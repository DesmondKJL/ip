import java.util.Scanner;


public class Duke {
    public static void main(String[] args) {
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


            if (startsWithList) { //list command given
                System.out.println("Here are the tasks in your list:");
                for (numeration = 1; numeration < itemNumber; numeration++) {
                    //System.out.println(numeration + " " + list[numeration].getStatusIcon() + " " + list[numeration].getDescription());
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


            } else { //add new item to list
                list[itemNumber] = new Task(line, isDone);
                itemNumber++;
                System.out.println("added: " + line);
            }

        }
        System.out.println("Bye. Hope to see you again soon!\n");

    }
}
