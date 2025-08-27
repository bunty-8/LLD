package pojo;

public class ToDo {
    private String task;
    private int id;
    boolean isDone;
    public ToDo(String task, int id){
        this.task = task;
        this.id = id;
        isDone = false;
    }
    public int getId() {return this.id;}
    public void markAsDone() {this.isDone = true;}
    public boolean isDone() {return this.isDone;}

    @Override
    public String toString() {
        return "[ " + this.id + " -> " + this.task + " ]";
    }
}
