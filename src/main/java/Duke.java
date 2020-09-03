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
        int hasBye = 1;
        int hasList = 1;
        int hasTodo = 1;
        int hasDeadline = 1;
        int hasEvent = 1;
        boolean startsWithdone = false;
        boolean isDone = false;


        while(hasBye != 0) {

            //waiting for user input
            line = in.nextLine();

            //checking command
            hasBye = ("bye").compareTo(line);
            hasList = ("list").compareTo(line);
            startsWithdone= line.startsWith("done");

            if(hasList == 0) { //list command given
                for(numeration = 1; numeration < itemNumber; numeration++) {

                    System.out.println(numeration + " " + list[numeration].getStatusIcon() + " " + list[numeration].getDescription());
                }

            }

            else if(startsWithdone == true) { //done command given
                itemDone = Integer.parseInt(line.substring(5));
                list[itemDone].markAsDone();
                System.out.println("Nice! I've marked this task as done:\n    \u2713 " + list[itemDone].getDescription());
            }

            //else if()

            else { //add new item to list
                list[itemNumber] = new Task(line, isDone);
                itemNumber++;
                System.out.println("added: " + line);
            }

        }
        System.out.println("Bye. Hope to see you again soon!\n");

    }
}
