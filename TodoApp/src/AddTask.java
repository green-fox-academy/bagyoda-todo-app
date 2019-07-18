import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AddTask {

    public void addTaskToList(String args1){

          writeToFile(args1);
    }

    public void writeToFile(String args1){
        String inputFile = "todo.txt";

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile, true));
            writer.write("\n" + args1);
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to write file : " + inputFile);
        }

        System.out.println("Task has succesfully been added to your list.");

    }

}
