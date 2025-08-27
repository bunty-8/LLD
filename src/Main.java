import service.ToDoService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ToDoService toDoService = new ToDoService();
        toDoService.addTask("merge the pr");
        toDoService.addTask("discuss if we need to gack on contract renewal issues");
        toDoService.showAllTasks();
        toDoService.markAsDone(1);
        toDoService.addTask("need to start lld");
        toDoService.showDoneTasks();
        toDoService.showUnDoneTasks();
    }
}