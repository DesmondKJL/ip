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

        String str1 = "bye";
        String line;
        int var1 = 1;
        while(var1 != 0) {

            line = in.nextLine();
            var1 = str1.compareTo(line);


            System.out.println(line);
        }
        System.out.println("Bye. Hope to see you again soon!\n");







    }
}
