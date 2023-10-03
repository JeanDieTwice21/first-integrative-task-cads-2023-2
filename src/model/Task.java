package model;
import java.util.Objects;
public class Task{

    private int id;
    private String desc;
    private Priority priority;

    public Task(int id, String desc, Priority priority){

        this.id = id;
        this.desc = desc;
        this.priority = priority;

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

        return " Priority: " + priority + "\n Description: " + desc;

    }


}
