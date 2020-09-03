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


        String line;
        int[] state;
        state = new int[100];
        Task[] list;
        list = new Task[100];

        int hasBye = 1;
        int hasList = 1;
        boolean isDone = false;
        int itemNumber = 1;
        int itemDone = 0;
        boolean startswithDone = false;




        while(hasBye != 0) {

            line = in.nextLine();
            hasBye = ("bye").compareTo(line);
            hasList = ("list").compareTo(line);
            startswithDone= line.startsWith("done");


            if(hasList == 0) { //list command given
                for(int numeration = 1; numeration < itemNumber; numeration++) {

                    System.out.println(numeration + " " + list[numeration].getStatusIcon() + " " + list[numeration].getDescription());
                }

            }

            else if(startswithDone == true) {
                itemDone = Integer.parseInt(line.substring(5));
                list[itemDone].markAsDone();
            }

            else {
                list[itemNumber] = new Task(line, isDone);
                itemNumber++;
                System.out.println("added: " + line);
            }



        }
        System.out.println("Bye. Hope to see you again soon!\n");

    }
}

//    String notDone = ". [✗] ";
//    String isDone = ". [✓] ";        int numeration = 1;
//        if(var2 == 0){ // list command
//        for(int k = 0; k < itemNumber; k++){
//        if(state[k] == 1){
//        System.out.println(numeration + isDone + list[k]);
//        }
//        else{
//        System.out.println(numeration + notDone + list[k]);
//        }
//
//        numeration++;
//
//        }
//
//        }
//        else{
