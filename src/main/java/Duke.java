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
        String str2 = "list";
        String line;
        String[] list;
        list = new String[100];

        int var1 = 1;
        int var2 = 1;
        int i = 0;
        int numeration = 1;
        while(var1 != 0) {

            line = in.nextLine();
            var1 = str1.compareTo(line);
            var2 = str2.compareTo(line);
            if(var2 == 0){
                for(int k = 0; k < i; k++){
                    System.out.println(numeration + ". " + list[k]);
                    numeration++;
                }

            }
            else{
                list[i] = line;
                i++;
                System.out.println("added: " + line);
            }

        }
        System.out.println("Bye. Hope to see you again soon!\n");
        
    }
}
