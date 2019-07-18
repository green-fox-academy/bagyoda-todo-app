import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CheckCompletion {

    ListTasks listTasksInstance = new ListTasks();

    public void checkCompletionInput(String args1) {

        listTasksInstance.readFromFile();
        int listSize = listTasksInstance.taskContainer.size();

        int r = 0;
        try {
            r = Integer.parseInt(args1);
            if (r > listSize){
                System.out.println("Unable to check: index is out of bound");
            } else {
                completionModifier(listTasksInstance.taskContainer, r);
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Unable to check: index is not a number");
        }
    }

    private void completionModifier(List<Task> taskContainer, int r) {

        String fileName = "todo.txt";
        String s = taskContainer.get(r-1).description;
        char ch = s.charAt(1);
        if (ch == 'x') {
            System.out.println("Task is already completed.");
        } else {
            StringBuilder newString = new StringBuilder(taskContainer.get(r-1).description);
            newString.setCharAt(1,'x');
            String sourceStr = newString.toString();
            taskContainer.get(r-1).description = sourceStr;

            System.out.println("Given task just has been completed.");

        }

        try{
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < taskContainer.size(); i++) {
                out.write(taskContainer.get(i).description);
                out.newLine();
            }
            out.close();
        } catch (Exception e){

        }

    }
}
