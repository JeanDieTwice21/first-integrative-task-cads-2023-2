package ui;
import model.TaskManager;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private Scanner reader;
    private int taskCount;
    private TaskManager controller;

    public Main(){

        reader = new Scanner(System.in);
        taskCount = 1;
        controller = new TaskManager();
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
        System.out.println("|             2. View tasks                 |");
        System.out.println("|             3. Modify task                |");
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
                break;

            case 2:
                System.out.println("-------------------------------------------");
                viewTasks();
                break;

            case 3:
                System.out.println("-------------------------------------------");
                modifyTask();
                break;

            case 4:
                System.out.println("-------------------------------------------");
                undo();
                break;

            case 5:

                System.out.println("--------------");
                System.out.println("\n   Goodbye!   \n");
                System.out.println("--------------");
                break;
        }

    }


    public void addTask(){

        Random random = new Random();
        String taskTitle = " ";
        String taskDesc1 = " ";
        String taskDesc2 = " ";
        String limitDate = " ";
        int taskPriority = 0;
        int taskId = random.nextInt(100);


        System.out.println("Type the title of the task: ");
        taskTitle = reader.next();
        System.out.println("Type the task description: ");
        taskDesc1 = reader.next();
        taskDesc2 = reader.nextLine();
        System.out.println("Type the limit date for the task: ");
        limitDate = reader.nextLine();
        System.out.println("Choose the priority: ");
        System.out.println("1. Priority");
        System.out.println("2. Non-priority");
        taskPriority =  reader.nextInt();

        String taskDesc = taskDesc1 + taskDesc2;
        System.out.println(controller.addTask(taskCount, taskId, taskTitle, taskDesc, limitDate, taskPriority));
        taskCount++;

    }

    public void modifyTask(){


        int key = 0;
        String newDesc = " ";

        System.out.println("Type the key of the task to modify: ");
        key = reader.nextInt();
        System.out.println("Type the new description: ");
        newDesc = reader.next();

        System.out.println(controller.modifyTask(key,newDesc));

    }

    public void viewTasks(){

        int option = 0;


        do {
            System.out.println("-----------------------------------\n");
            System.out.println("Choose an option: ");
            System.out.println("\n1. View priority tasks.\n");
            System.out.println("2. View non priority tasks.\n");
            System.out.println("3. View all tasks.\n");
            System.out.println("4. Return to menu.");
            System.out.println("----------------------------------");
            option = reader.nextInt();

            switch (option) {


                case 1:

                    System.out.println(controller.showPriorityTasks());
                    break;

                case 2:

                    System.out.println(controller.showNonPrioTasks());
                    break;

                case 3:

                    System.out.println(controller.showTasks());
                    break;
            }

        }while(option != 4);
    }

    public void undo(){

       System.out.println(controller.undo());
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
