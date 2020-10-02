import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    public Storage() {

    }


    public void save(TaskList taskings) {

        try {
            FileWriter fw = new FileWriter("./data/duke.txt");
            for (Task task : taskings) {
                String listOfTasks = task.toString() + System.lineSeparator();
                fw.append(listOfTasks);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Cannot save data to disk!");
            e.printStackTrace();
        }
    }
}
