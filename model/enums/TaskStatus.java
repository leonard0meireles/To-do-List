public enum TaskStatus {
    PENDING("PENDING"),
    COMPLETED("COMPLETED");

    private String status;
    
    TaskStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String newStatus){
        this.status = newStatus;
    }

    @Override
    public String toString(){
        return this.status; 
    }
}
