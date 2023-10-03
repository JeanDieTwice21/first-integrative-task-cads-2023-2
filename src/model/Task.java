package model;

public class Task{

    private int id;
    private String title;
    private String limitDate;

    private String desc;
    private Priority priority;


    public Task(int id, String title, String limitDate, String desc, Priority priority){

        this.id = id;
        this.title = title;
        this.limitDate = limitDate;
        this.desc = desc;
        this.priority = priority;

    }

    public void setDesc(String newDesc){

        this.desc = newDesc;

    }

    public int getId(){

        return id;
    }
    public Priority getPrio(){

        return priority;

    }

    public String getDesc(){

        return desc;

    }

    @Override
    public String toString(){

        return  title + "\nPriority: " + priority + "\nDescription: " + desc + "\nLimit date: " + limitDate;

    }




}
