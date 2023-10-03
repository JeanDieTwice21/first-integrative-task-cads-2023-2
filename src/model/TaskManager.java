package model;

public class TaskManager{

    private HashTable<Integer, Task> taskTable;
    private Queue<Task> priorityQueue, nonPrioQueue;
    public TaskManager(){

        taskTable = new HashTable<>(10);
        priorityQueue = new Queue<>();
        nonPrioQueue = new Queue<>();
    }

    public String addTask(int key, int id, String title, String desc, String limitDate, int prio){

        String msg = "";
        if(taskTable.getSize() != 10){

            Priority priority = null;
            if(prio ==  1){

                priority = Priority.PRIORITY;
            }
            else if (prio == 2){

                priority = Priority.NONPRIORITY;

            }

            Task newTask = new Task(id, title, limitDate, desc, priority);

            taskTable.put(key, newTask);

            if(priority == Priority.PRIORITY){

                priorityQueue.enqueue(newTask);
            }
            else if(priority == Priority.NONPRIORITY){

                nonPrioQueue.enqueue(newTask);
            }
            msg = "Task added.";
        }
        else{

            msg = "Table full!";
        }

        return msg;
    }

    public String modifyTask(int key, String newDesc){

        String msg = " ";
        Task task = taskTable.get(key);
        if(task == null){

            msg = "Couldnt find task.";
        }
        else{

            task.setDesc(newDesc);
            msg = "Task modified.";
        }

        return msg;
    }

    public String showTasks(){

        return taskTable.toString();

    }
}
