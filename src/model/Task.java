package model;

import java.util.Date;

public class Task implements Comparable<Task>{

    private int id;
    private String title;
    private Date limitDate;

    private String desc;
    private Priority priority;


    public Task(int id, String title, Date limitDate, String desc, Priority priority){

        this.id = id;
        this.title = title;
        this.limitDate = limitDate;
        this.desc = desc;
        this.priority = priority;

    }

    public void setLimitDate(Date newDate){

        this.limitDate = newDate;
    }

    public Date getLimitDate(){

        return limitDate;
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

        return  "Task{" + title + "\nPriority: " + priority + "\nDescription: " + desc + "\nLimit date: " + limitDate + "}";

    }


    @Override
    public int compareTo(Task o){

        return this.getLimitDate().compareTo(o.getLimitDate());
    }
}
