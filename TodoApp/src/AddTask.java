import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AddTask {

    public void addTaskToList(String args1){

//          writeToFile(args1, false);
        writeToFile(args1);
    }

    public void writeToFile(String args1){
        String inputFile = "todo.txt";

        try{
            Path filePath = Paths.get(inputFile);
            List<String> temp = Files.readAllLines(filePath);
            temp.add("[ ] " + args1);
            Files.write(filePath, temp);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to write file : " + inputFile);
        }

        System.out.println("Task has succesfully been added to your list.");

    }

}
