public class Parser {


     public static boolean startsWithBye(String userInput){
         return (userInput.startsWith("bye"));
     }

     public boolean startsWithList(String userInput){
        return (userInput.startsWith("list"));
     }

    public boolean startsWithDone(String userInput){
        return (userInput.startsWith("done"));
    }
    public static boolean startsWithTodo(String userInput){
        return (userInput.startsWith("todo"));
    }
    public boolean startsWithEvent(String userInput){
        return (userInput.startsWith("event"));
    }
    public static boolean startsWithDeadline(String userInput){
        return (userInput.startsWith("deadline"));
    }
    public boolean startsWithDelete(String userInput){
        return (userInput.startsWith("delete"));
    }
    public boolean startsWithFind(String userInput){
        return (userInput.startsWith("Find"));
    }

//    boolean startsWithBye = false;
//    boolean startsWithList = false;
//    boolean startsWithDone = false;
//    boolean startsWithTodo = false;
//    boolean startsWithDeadline = false;
//    boolean startsWithEvent = false;
//    boolean startsWithDelete = false;
//    boolean startsWithFind = false;
//    startsWithBye = line.startsWith("bye");
//    startsWithList = line.startsWith("list");
//    startsWithDone = line.startsWith("done");
//    startsWithDeadline = line.startsWith("deadline");
//    startsWithTodo = line.startsWith("todo");
//    startsWithEvent = line.startsWith("event");
//    startsWithDelete = line.startsWith("delete");
//    startsWithFind = line.startsWith("find");
}
