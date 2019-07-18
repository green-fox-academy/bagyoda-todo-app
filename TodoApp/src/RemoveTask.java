import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RemoveTask {

    ListTasks listTasksInstance = new ListTasks();

    public void parseChecker(String args1){

        listTasksInstance.readFromFile();
        int listSize = listTasksInstance.taskContainer.size();

        int r = 0;
        try {
            r = Integer.parseInt(args1);
            if (r > listSize){
                System.out.println("Unable to remove: index is out of bound");
            } else {
                removeTask(listTasksInstance.taskContainer, r);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to remove: index is not a number");
        }
    }

    private void removeTask(List<Task> taskContainer, int num) {

        taskContainer.remove(num-1);
        String fileName = "todo.txt";

        try{
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < taskContainer.size(); i++) {
            out.write(taskContainer.get(i).description);
            out.newLine();
        }
        out.close();
        } catch (Exception e){

        }


        System.out.println("Your task has succesfully been removed.");
    }

}
