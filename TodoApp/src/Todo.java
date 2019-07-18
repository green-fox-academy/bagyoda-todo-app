import java.util.List;

public class Todo {

    static ListTasks listTasksInstance = new ListTasks();
    static AddTask addTaskInstance = new AddTask();

    public static void main(String[] args) {

        switch (args.length){
            case 0:
            printUsage();
                break;

            case 1:
            measureCaseOne(args);
                break;

            case 2:
                measureCaseTwo(args);
                break;

        }

    }

    public static void printUsage(){
        System.out.println();
        System.out.println("Command Line Todo application");
        System.out.println("=============================");
        System.out.println();
        System.out.println("Command line arguments:");
        System.out.println("    -l   Lists all the tasks");
        System.out.println("    -a   Adds a new task");
        System.out.println("    -r   Removes an task");
        System.out.println("    -c   Completes an task");
    }

    public static void measureCaseOne(String[] args){

        switch (args[0]){
            case "-l":
                listTasksInstance.listAllTasks();
                break;
            case "-a":
                System.out.println("Unable to add: no task provided");
                break;
            case "-r":
                System.out.println("-r/ not implemented yet");
                break;
            case "-c":
                System.out.println("-c/ not implemented yet");
                break;
        }
    }

    private static void measureCaseTwo(String[] args) {

        if (args[0].equals("-a")){
            addTaskInstance.addTaskToList(args[1]);
        }

    }

}
