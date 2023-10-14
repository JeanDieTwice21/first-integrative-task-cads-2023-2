package model;
import util.HashTable;
import util.PriorityQueue;
import util.Stack;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class TaskManager{

    private HashTable<Integer, Task> taskTable;
    private PriorityQueue<Task> priorityQueue;
    private PriorityQueue<Task> nonPrioQueue;
    private Stack<ActionRecord> actions;
    private SimpleDateFormat format;

    public TaskManager(){

        taskTable = new HashTable<>(10);
        priorityQueue = new PriorityQueue<>();
        nonPrioQueue = new PriorityQueue<>();
        actions = new Stack<>();
        format = new SimpleDateFormat("dd/MM/yyyy");
    }

    public String addTask(int key, int id, String title, String desc, String limitDate, int prio) throws ParseException{

        String msg = "";
        Date taskDate = format.parse(limitDate);

        if(taskTable.getSize() != 10){

            Priority priority = null;
            if(prio ==  1){

                priority = Priority.PRIORITY;
            }
            else if (prio == 2){

                priority = Priority.NONPRIORITY;

            }

            Task newTask = new Task(id, title, taskDate, desc, priority);

            taskTable.put(key, newTask);

            if(priority == Priority.PRIORITY){

                priorityQueue.enqueue(newTask);
            }
            else if(priority == Priority.NONPRIORITY){

                nonPrioQueue.enqueue(newTask);
            }
            msg = "Task added.";

            actions.push(new ActionRecord(key,newTask, Action.ADD));
        }
        else{

            msg = "Table full!";
        }

        return msg;
    }

    public String modifyTask(int key, String newDesc, String newDate) throws ParseException{

        String msg = " ";
        Date newLimitDate = format.parse(newDate);
        Task task = taskTable.get(key);
        if(task == null){

            msg = "Couldn't find task.";
        }
        else{

            String modifiedDesc = task.getDesc();
            Date modifiedDate = task.getLimitDate();
            task.setDesc(newDesc);
            task.setLimitDate(newLimitDate);
            msg = "Task modified.";
            actions.push(new ActionRecord(key, modifiedDesc, modifiedDate, Action.MODIFY));
        }

        return msg;
    }

    public String removeTask(int key){

        String msg = "";
        Task removedTask = taskTable.get(key);

        if(removedTask != null) {

            taskTable.remove(key);
            actions.push(new ActionRecord(key, removedTask, Action.REMOVE));

            if (removedTask.getPrio() == Priority.PRIORITY) {

                priorityQueue.dequeue();
            } else if (removedTask.getPrio() == Priority.NONPRIORITY) {

                nonPrioQueue.dequeue();

            }

            msg = "Task removed.";
        }
        else{

            msg = "Couldn't find task!";
        }

        return msg;

    }

    public String showPriorityTasks(){


        return priorityQueue.toString();

    }

    public String showNonPrioTasks(){

        return nonPrioQueue.toString();
    }
    public String showTasks(){

        return taskTable.toString();

    }

    public String undo() {

        String msg = "";
        ActionRecord action = actions.pop();

        if(action != null) {


            if (action.getType() == Action.ADD) {

                Task addedTask = action.getTask();
                int addedTKey = action.getTKey();
                taskTable.remove(addedTKey);
                if(addedTask.getPrio() == Priority.PRIORITY) {
                    priorityQueue.remove(addedTask);
                }
                else if(addedTask.getPrio() == Priority.NONPRIORITY){

                    nonPrioQueue.remove(addedTask);
                }

                msg = "Add action undone.";

            } else if (action.getType() == Action.MODIFY) {

                int modifiedTKey = action.getModifiedTKey();
                String modifiedDesc = action.getModifiedDesc();
                Date modifiedDate = action.getModifiedDate();

                Task modifiedTask = taskTable.get(modifiedTKey);
                modifiedTask.setDesc(modifiedDesc);
                modifiedTask.setLimitDate(modifiedDate);

                msg = "Modify action undone.";

            } else if (action.getType() == Action.REMOVE) {

                Task removedTask = action.getTask();
                int removedTKey = action.getTKey();

                taskTable.put(removedTKey, removedTask);

                if(removedTask.getPrio() == Priority.PRIORITY){

                    priorityQueue.enqueue(removedTask);

                }
                else if(removedTask.getPrio() == Priority.NONPRIORITY){

                    nonPrioQueue.enqueue(removedTask);
                }

                msg = "Remove action undone.";
            }
        }
        else{

            msg = "No actions recorded.";
        }
        return msg;

    }
}
