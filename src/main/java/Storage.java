import java.io.FileWriter;
import java.io.IOException;
/**
 * Object class that deals with saving tasks in the file
 */
public class Storage {
    /**
     * Creates a storage object
     */
    public Storage() {

    }

    /**
     * Saves data onto file
     *
     * @param  taskings is the tasklist currently accessed by the user
     */
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
