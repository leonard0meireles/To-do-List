import model.entities.Task;
import model.entities.TaskStatus;
import model.utils.LinkedList;

public class Main {
    public static void main(String[] args){
        Task task1 = new Task(1, "Daily with a team", "meeting");
        Task task2 = new Task(2, "Implement some feature", "job", TaskStatus.COMPLETED);

        System.out.println(task1);
        System.out.println(task2);

        LinkedList<Task> tasks = new LinkedList<>();
        
        System.out.println("Is the list empty? " + tasks.isEmpty());
    }
}
