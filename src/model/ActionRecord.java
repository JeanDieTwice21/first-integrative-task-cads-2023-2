package model;

public class ActionRecord{

    private Task action;

    private Action actionType;
    private String modifiedAt;
    private int modifiedTKey;
    private int tKey;

    public ActionRecord(int tKey, Task action, Action actionType){

        this.tKey = tKey;
        this.action = action;
        this.actionType = actionType;
    }

    public ActionRecord(int modifiedTKey, String modifiedAt, Action actionType){

        this.modifiedAt = modifiedAt;
        this.actionType = actionType;
        this.modifiedTKey = modifiedTKey;
    }



    public int getTKey(){

        return tKey;
    }
    public String getModifiedAt(){

        return modifiedAt;
    }
    public int getModifiedTKey(){

        return modifiedTKey;
    }
    public Task getTask(){

        return action;
    }

    public Action getType(){

        return actionType;
    }

}
