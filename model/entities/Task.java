public class Task {
    private Integer id;
    private String description;
    private String tag;
    private TaskStatus taskStatus;


    public Task(Integer id, String desc, String tag){
        this.id = id;
        this.description = desc;
        this.tag = tag;
        this.taskStatus = TaskStatus.PENDING;
    }

    public Task(Integer id, String desc, String tag, TaskStatus taskStatus){
        this.id = id;
        this.description = desc;
        this.tag = tag;
        this.taskStatus = taskStatus;
    }

    public Integer getId(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public String getTag(){
        return this.tag;
    }

    public TaskStatus getTaskStatus(){
        return this.taskStatus;
    }


    public void setDescription(String newDesc){
        this.description = newDesc;
    }

    public void setTag(String newTag){
        this.tag = newTag;
    }

    public void setTaskStatus(TaskStatus newTaskStatus){
        this.taskStatus = newTaskStatus;
    }

    @Override
    public String toString(){
        return String.format("Task %d: \n Description: %s | Tag: %s | Status: %s", this.id, this.description, this.tag, this.taskStatus);
    }
}
