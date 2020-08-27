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


        String str1 = "bye";
        String line;
        line = in.nextLine();
        int var1 = str1.compareTo( line );

        if (var1 == 0){
            System.out.println("Bye. Hope to see you again soon!\n");
        }

        else{
            System.out.println(line);
        }





    }
}
