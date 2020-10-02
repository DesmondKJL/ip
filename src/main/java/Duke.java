import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


public class Duke {


    private TaskList taskings;
    private Storage storage;
    private Ui ui;
    private Parser parse;


    public Duke(String filePath) {
        ui = new Ui();
        ui.displayWelcomeMessage();
        parse = new Parser();
        storage = new Storage();
        Scanner in = new Scanner(System.in);
        String line = "";
        int itemNumber = 0;
        TaskList taskings =  new TaskList();
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
                    taskings.get(itemNumber-1).markAsDone();
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

        while (!parse.startsWithBye(line)) {

            //waiting for user input
            line = in.nextLine();

            if (parse.startsWithList(line)) { //list command given

                System.out.println("Here are the tasks in your list:");
                for (numeration = 0; numeration < itemNumber; numeration++) {
                    System.out.println(numeration + 1 + "." + taskings.get(numeration).toString());
                }

            } else

                try {

                    if (parse.startsWithDone(line)) { //done command given
                        itemDone = Integer.parseInt(line.substring(5));
                        taskings.get((itemDone - 1)).markAsDone();
                        System.out.println("Nice! I've marked this task as done:\n    \u2713 " + taskings.get(itemDone - 1).getDescription());

                    } else if (parse.startsWithDeadline(line)) { //deadline command given
                        indexOfBackslash = line.indexOf("/");
                        deadlineDate = line.substring(indexOfBackslash + 4);
                        line = line.substring(9, indexOfBackslash - 1);
                        taskings.add(new Deadline(line, deadlineDate));
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (parse.startsWithTodo(line)) { //todo command given
                        taskings.add(new Todo(line.substring(5)));
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (parse.startsWithEvent(line)) { //event command given
                        indexOfBackslash = line.indexOf("/");
                        deadlineDate = line.substring(indexOfBackslash + 4);
                        line = line.substring(6, indexOfBackslash - 1);
                        taskings.add(new Event(line, deadlineDate));
                        System.out.println("Got it. I've added this task:\n  " + taskings.get(itemNumber).toString() + "\nNow you have " + (itemNumber + 1) + " tasks in the list.");
                        itemNumber++;

                    } else if (parse.startsWithDelete(line)) {

                        taskNumber = Integer.parseInt(line.substring(7));
                        System.out.println("Noted. I've removed this task: \n  " + taskings.get(taskNumber - 1).toString() + "\nNow you have " + (itemNumber - 1) + " tasks in the list.");
                        taskings.remove(taskNumber - 1);
                        itemNumber--;

                    } else if (parse.startsWithFind(line)) {
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


                    } else if (!parse.startsWithBye(line)) {
                        throw new DukeExceptions();

                    }


                } catch (IndexOutOfBoundsException e) {
                    if (parse.startsWithTodo(line)) {
                        ui.displayTodoErrorMessage();
                    } else if (parse.startsWithEvent(line)) {
                        ui.displayEventErrorMessage();
                    } else if (parse.startsWithDeadline(line)) {
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

    public static void main(String[] args) throws DukeExceptions {

        new Duke("./data");

    }
}
