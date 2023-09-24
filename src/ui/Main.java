package ui;
import java.util.Scanner;

public class Main {

    private Scanner reader;

    public Main(){

        reader = new Scanner(System.in);

    }

    public static void main(String[] args){

        Main m = new Main();
        int choice = 0;

        do{

            m.showMenu();
            choice = m.validateIntegerInput();
            m.executeChoice(choice);



        }while(choice != 5);

    }

    public void showMenu(){


        System.out.println("|-------------------------------------------|");
        System.out.println("|                                           |");
        System.out.println("|       Welcome to the Task Manager         |");
        System.out.println("|                                           |");
        System.out.println("|             1. Add task.                  |");
        System.out.println("|             2. Modify task.               |");
        System.out.println("|             3. View tasks.                |");
        System.out.println("|             4. Undo.                      |");
        System.out.println("|             5. Exit.                      |");
        System.out.println("|                                           |");
        System.out.println("|-------------------------------------------|");
    }

    public void executeChoice(int choice){


        switch(choice){

            case 1:
                System.out.println("-------------------------------------------");
                addTask();
                //FIXME Add Task method.
                break;

            case 2:
                System.out.println("-------------------------------------------");
                //modifyTask();
                //FIXME Modify Task method.
                break;

            case 3:
                System.out.println("-------------------------------------------");
                //viewTasks();
                //FIXME View Tasks method.
                break;

            case 4:
                System.out.println("-------------------------------------------");
                //undo();
                //FIXME Undo method.
                break;

            case 5:

                System.out.println("--------------");
                System.out.println("\n   Goodbye!   \n");
                System.out.println("--------------");
                break;
        }

    }


    public void addTask(){

        String taskTitle = " ";
        String taskDesc = " ";
        String limitDate = " ";
        int taskPriority = 0;

        System.out.println("Type the title of the task: ");
        taskTitle = reader.next();
        System.out.println("Type the task description: ");
        taskDesc = reader.next();
        System.out.println("Type the limit date for the task: ");
        limitDate = reader.next();
        System.out.println("Choose the priority: ");
        System.out.println("1. Priority");
        System.out.println("2. Non-priority");
        taskPriority =  reader.nextInt();


    }

    public int validateIntegerInput(){

        int option = 0;
        if(reader.hasNextInt()){
            option = reader.nextInt();
        }
        else{
            reader.nextLine();
            option = -1;
            System.out.println("Enter a valid value.");
        }
        return option;

    }

}
