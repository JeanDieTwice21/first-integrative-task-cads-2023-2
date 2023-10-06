package model;

public class TaskManager{

    private HashTable<Integer, Task> taskTable;
    private Queue<Task> priorityQueue;
    private Queue<Task> nonPrioQueue;
    private Stack<ActionRecord> actions;
    public TaskManager(){

        taskTable = new HashTable<>(10);
        priorityQueue = new Queue<>();
        nonPrioQueue = new Queue<>();
        actions = new Stack<>();
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

            actions.push(new ActionRecord(key,newTask, Action.ADD));
        }
        else{

            msg = "Table full!";
        }

        return msg;
    }

    public String modifyTask(int key, String newDesc, String newDate){

        String msg = " ";
        Task task = taskTable.get(key);
        if(task == null){

            msg = "Couldnt find task.";
        }
        else{

            String modifiedDesc = task.getDesc();
            String modifiedDate = task.getLimitDate();
            task.setDesc(newDesc);
            task.setLimitDate(newDate);
            msg = "Task modified.";
            actions.push(new ActionRecord(key, modifiedDesc, modifiedDate, Action.MODIFY));
        }

        return msg;
    }

    public String removeTask(int key){

        String msg = "";
        Task removedTask = taskTable.get(key);
        taskTable.remove(key);
        actions.push(new ActionRecord(key,removedTask, Action.REMOVE));
        msg = "Task removed.";

        if(removedTask.getPrio() == Priority.PRIORITY){

            priorityQueue.dequeue();
        }
        else if(removedTask.getPrio() == Priority.NONPRIORITY){

            nonPrioQueue.dequeue();

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

                msg = "Add action undone.";

            } else if (action.getType() == Action.MODIFY) {

                int modifiedTKey = action.getModifiedTKey();
                String modifiedDesc = action.getModifiedDesc();
                String modifiedDate = action.getModifiedDate();

                Task modifiedTask = taskTable.get(modifiedTKey);
                modifiedTask.setDesc(modifiedDesc);
                modifiedTask.setLimitDate(modifiedDate);

                msg = "Modify action undone.";

            } else if (action.getType() == Action.REMOVE) {

                Task removedTask = action.getTask();
                int removedTKey = action.getTKey();

                taskTable.put(removedTKey, removedTask);

                msg = "Remove action undone.";
            }
        }
        else{

            msg = "No actions recorded.";
        }
        return msg;

    }
}
