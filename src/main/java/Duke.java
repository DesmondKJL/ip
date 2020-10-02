import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Object class of duke
 */
public class Duke {


    private TaskList taskings;
    private Storage storage;
    private Ui ui;
    private Parser parse;
    
    public Duke() {
        ui = new Ui();
        ui.displayWelcomeMessage();
        parse = new Parser();
        storage = new Storage();
        Scanner in = new Scanner(System.in);
        String userInput = new String();
        int itemNumber = 0;
        TaskList taskings = new TaskList();
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
            sc.useDelimiter("\\n");


            while (sc.hasNext()) {

                String function = sc.next();
                int indexOfRightBracket = 0;
                int indexOfLeftBracket = 0;
                String deadlineDate;
                String done = "";

                if (function.startsWith("[D]")) {

                    done = function.substring(4, 5);
                    indexOfRightBracket = function.indexOf(")");
                    indexOfLeftBracket = function.indexOf("(");
                    deadlineDate = function.substring(indexOfLeftBracket + 5, indexOfRightBracket);
                    function = function.substring(6, indexOfLeftBracket - 1);
                    taskings.add(new Deadline(function, deadlineDate));
                    itemNumber++;

                } else if (function.startsWith("[T]")) {
                    done = function.substring(4, 5);
                    function = function.substring(6);
                    taskings.add(new Todo(function));
                    itemNumber++;

                } else if (function.startsWith("[E]")) {
                    done = function.substring(4, 5);
                    indexOfRightBracket = function.indexOf(")");
                    indexOfLeftBracket = function.indexOf("(");
                    deadlineDate = function.substring(indexOfLeftBracket + 5, indexOfRightBracket);
                    function = function.substring(6, indexOfLeftBracket - 1);
                    taskings.add(new Event(function, deadlineDate));
                    itemNumber++;
                }
                if (done.equals("\u2713")) {
                    taskings.get(itemNumber - 1).markAsDone();
                }

            }
            sc.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //variables for list
        int itemDone = 0;
        int numeration = 1;
        int taskNumber = 0;

        //other variables
        int indexOfBackslash = 0;
        String deadlineDate;

        while (!parse.startsWithBye(userInput)) {

            //waiting for user input
            userInput = in.nextLine();

            if (parse.startsWithList(userInput)) { //list command given

                System.out.println("Here are the tasks in your list:");
                for (numeration = 0; numeration < itemNumber; numeration++) {
                    System.out.println(numeration + 1 + "." + taskings.get(numeration).toString());
                }

            } else

                try {

                    if (parse.startsWithDone(userInput)) { //done command given
                        itemDone = Integer.parseInt(userInput.substring(5));
                        taskings.get((itemDone - 1)).markAsDone();
                        System.out.println("Nice! I've marked this task as done:\n    \u2713 " + taskings.get(itemDone - 1).getDescription());

                    } else if (parse.startsWithDeadline(userInput)) { //deadline command given
                        indexOfBackslash = userInput.indexOf("/");
                        deadlineDate = userInput.substring(indexOfBackslash + 4);
                        userInput = userInput.substring(9, indexOfBackslash - 1);
                        taskings.add(new Deadline(userInput, deadlineDate));
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (parse.startsWithTodo(userInput)) { //todo command given
                        taskings.add(new Todo(userInput.substring(5)));
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (parse.startsWithEvent(userInput)) { //event command given
                        indexOfBackslash = userInput.indexOf("/");
                        deadlineDate = userInput.substring(indexOfBackslash + 4);
                        userInput = userInput.substring(6, indexOfBackslash - 1);
                        taskings.add(new Event(userInput, deadlineDate));
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (parse.startsWithDelete(userInput)) {

                        taskNumber = Integer.parseInt(userInput.substring(7));
                        System.out.println("Noted. I've removed this task: \n  " + taskings.get(taskNumber - 1).toString() + "\nNow you have " + (itemNumber - 1) + " tasks in the list.");
                        taskings.remove(taskNumber - 1);
                        itemNumber--;

                    } else if (parse.startsWithFind(userInput)) {
                        int numberOfMatchedTasks = 0;

                        userInput = userInput.substring(5);
                        System.out.println("Here are the matching tasks in your list:");
                        for (numeration = 0; numeration < itemNumber; numeration++) {
                            String check = taskings.get(numeration).toString();
                            if (check.contains(userInput)) {
                                numberOfMatchedTasks++;
                                System.out.println((numeration + 1) + ". " + check);
                            }
                        }


                    } else if (!parse.startsWithBye(userInput)) {
                        throw new DukeExceptions();

                    }


                } catch (IndexOutOfBoundsException e) {
                    if (parse.startsWithTodo(userInput)) {
                        ui.displayTodoErrorMessage();
                    } else if (parse.startsWithEvent(userInput)) {
                        ui.displayEventErrorMessage();
                    } else if (parse.startsWithDeadline(userInput)) {
                        ui.displayDeadlineErrorMessage();
                    }
                } catch (NullPointerException e) {
                    ui.displayGeneralErrorMessage();
                } catch (NumberFormatException e) {
                    ui.displayGeneralErrorMessage();
                } catch (DukeExceptions e) {
                    ui.displayGeneralErrorMessage();
                }

        }
        storage.save(taskings);
        ui.displayByeMessage();
    }


    /**
     * Runs duke
     */
    public static void main(String[] args) throws DukeExceptions {

        new Duke();

    }
}
