package model;

public class ActionRecord{

    private Task action;

    private Action actionType;
    private String modifiedDesc, modifiedDate;
    private int modifiedTKey;
    private int tKey;

    public ActionRecord(int tKey, Task action, Action actionType){

        this.tKey = tKey;
        this.action = action;
        this.actionType = actionType;
    }

    public ActionRecord(int modifiedTKey, String modifiedDesc, String modifiedDate, Action actionType){

        this.modifiedDesc = modifiedDesc;
        this.modifiedDate = modifiedDate;
        this.actionType = actionType;
        this.modifiedTKey = modifiedTKey;
    }



    public int getTKey(){

        return tKey;
    }

    public String getModifiedDate(){

        return modifiedDate;
    }
    public String getModifiedDesc(){

        return modifiedDesc;
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
