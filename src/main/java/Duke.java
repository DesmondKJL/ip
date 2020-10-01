import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


public class Duke {

    protected static final String TODO_ERROR = "☹ OOPS!!! The description of a todo cannot be empty.";
    protected static final String DEADLINE_DESCRIPTION_ERROR = "☹ OOPS!!! The description of a deadline cannot be empty.";
    protected static final String EVENT_DESCRIPTION_ERROR = "☹ OOPS!!! The description of a event cannot be empty.";
    protected static final String DEADLINE_DATE_ERROR = "☹ OOPS!!! Please add a date for this deadline task";
    protected static final String EVENT_DATE_ERROR = "☹ OOPS!!! Please add a date for this event task";
    protected static final String DONE_WRONG_NUMBER_ERROR = "☹ OOPS!!! Please provide a valid task number";
    protected static final String DONE_ERROR = "☹ OOPS!!! Please input the command correctly (e.g done 1)";
    protected static final String GENERAL_ERROR = "☹ OOPS!!! I'm sorry, but I don't know what that means :-(";


    public static void main(String[] args) throws DukeExceptions {

        int itemNumber = 0;
        //creating list of task
        ArrayList<Task> taskings = new ArrayList<>();

        File file = new File("./data");
        file.mkdir();
        File file1 = new File("./data/duke.txt");
        try {
            file1.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occured");
        }

        try {

            File file2 = new File("./data/duke.txt");
            Scanner sc = new Scanner(file2);
            sc.useDelimiter("/|\\n");


            while (sc.hasNext()) {

                //Get the info for the pet
                Task loadingTask;

                String function = sc.next();


                String done = sc.next();
                System.out.println(done);




                if (function.equals("D")) {
//
                    String description = sc.next();
                    String date = sc.next();
                    loadingTask = new Deadline(description, date);
                    taskings.add(loadingTask);
                    if (done.equals("1")) {
                        taskings.get(itemNumber).markAsDone();
                    }
                    itemNumber++;

                } else if (function.equals("T")) {
                    String restOfDescription = sc.next();
                    loadingTask = new Todo(restOfDescription);
                    taskings.add(loadingTask);
                    itemNumber++;
                } else if (function.equals("E")) {
                    String description = sc.next();
                    String date = sc.next();
                    loadingTask = new Event(description, date);
                    taskings.add(loadingTask);
                    itemNumber++;
                }

            }
            sc.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


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

        //variables for list

        int itemDone = 0;
        int numeration = 1;
        int taskNumber = 0;

        //variables to check command
        boolean startsWithBye = false;
        boolean startsWithList = false;
        boolean startsWithDone = false;
        boolean startsWithTodo = false;
        boolean startsWithDeadline = false;
        boolean startsWithEvent = false;
        boolean startsWithDelete = false;
        boolean startsWithFind = false;

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
            startsWithDelete = line.startsWith("delete");
            startsWithFind = line.startsWith("find");

            if (startsWithList) { //list command given

                System.out.println("Here are the tasks in your list:");
                for (numeration = 0; numeration < itemNumber; numeration++) {
                    System.out.println(numeration + 1 + "." + taskings.get(numeration).toString());
                }

            } else

                try {

                    if (startsWithDone) { //done command given
                        itemDone = Integer.parseInt(line.substring(5));
//                    list[itemDone].markAsDone();
                        taskings.get((itemDone - 1)).markAsDone();
                        System.out.println("Nice! I've marked this task as done:\n    \u2713 " + taskings.get(itemDone - 1).getDescription());
//                    System.out.println("Nice! I've marked this task as done:\n    \u2713 " + list[itemDone].getDescription());

                    } else if (startsWithDeadline) { //deadline command given
                        indexOfBackslash = line.indexOf("/");
                        deadlineDate = line.substring(indexOfBackslash + 4);
                        line = line.substring(9, indexOfBackslash - 1);
//                    list[itemNumber] = new Deadline(line, deadlineDate, isDone);
//                    System.out.println("Got it. I've added this task:\n  " + list[itemNumber].toString() + "\nNow you have " + itemNumber + " tasks in the list.");
                        taskings.add(new Deadline(line, deadlineDate));
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (startsWithTodo) { //todo command given
//                    list[itemNumber] = new Todo(line.substring(5), isDone);
                        taskings.add(new Todo(line.substring(5)));
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (startsWithEvent) { //event command given
                        indexOfBackslash = line.indexOf("/");
                        deadlineDate = line.substring(indexOfBackslash + 4);
                        line = line.substring(6, indexOfBackslash - 1);
                        taskings.add(new Event(line, deadlineDate));
//                    list[itemNumber] = new Event(line, deadlineDate, isDone);
//                    System.out.println("Got it. I've added this task:\n  " + list[itemNumber].toString() + "\nNow you have " + itemNumber + " tasks in the list.");
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (startsWithDelete) {

                        taskNumber = Integer.parseInt(line.substring(7));
                        System.out.println("Noted. I've removed this task: \n  " + taskings.get(taskNumber - 1).toString() + "\nNow you have " + (itemNumber - 1) + " tasks in the list.");
                        taskings.remove(taskNumber - 1);
                        itemNumber--;

                    } else if (startsWithFind) {
                        int numberOfMatchedTasks = 0;
                        line = line.substring(5);
                        System.out.println("Here are the matching tasks in your list:");
                        for (numeration = 0; numeration < itemNumber; numeration++) {
                            String check = taskings.get(numeration).toString();
                            if (check.contains(line)) {
                                numberOfMatchedTasks++;
                                System.out.println((numeration + 1) + ". " + check);
                            }
                        }


                    } else if (!startsWithBye) {
                        throw new DukeExceptions();
                    }


                } catch (IndexOutOfBoundsException e) {
                    if (startsWithTodo) {
                        System.out.println(TODO_ERROR);
                    } else if (startsWithEvent) {
                        System.out.println(EVENT_DESCRIPTION_ERROR);
                    } else if (startsWithDeadline) {
                        System.out.println(DEADLINE_DESCRIPTION_ERROR);
                    }
                } catch (NullPointerException e) {
                    System.out.println(DONE_WRONG_NUMBER_ERROR);
                } catch (NumberFormatException e) {
                    System.out.println(DONE_ERROR);
                } catch (DukeExceptions e) {
                    System.out.println(GENERAL_ERROR);
                }
        }

        System.out.println("Bye. Hope to see you again soon!\n");

    }
}
