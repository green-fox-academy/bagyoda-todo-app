import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ListTasks {


    List<Task> taskContainer = new ArrayList<>();

    public void listAllTasks(){
        readFromFile();
        System.out.println();
        int counter = 0;

        if (this.taskContainer.size() == 0){
            System.out.println("No todos for today! :)");
        } else {
            for (int i = 0; i <this.taskContainer.size() ; i++) {
                counter++;
                System.out.println(counter + " - " + this.taskContainer.get(i).description);
            }
        }
    }

    public void readFromFile(){

        String inputFile = "todo.txt";
        String fileLines = "";
        BufferedReader fileReader = null;

        try {
            fileReader = new BufferedReader(new FileReader(inputFile));
            while ((fileLines = fileReader.readLine()) != null) {
                Task taskInstance = new Task();
                taskInstance.description = fileLines;
                taskInstance.isDone = isDoneFromFile(fileLines);
                taskContainer.add(taskInstance);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean isDoneFromFile (String fileLines) {

        if (fileLines.contains("[x]")){
            return true;
        }
        return false;
    }

}


