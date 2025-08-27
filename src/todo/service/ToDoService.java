package todo.service;

import todo.pojo.ToDo;
import todo.storage.FileStorage;

import java.util.List;

public class ToDoService {
    private List<ToDo> todos;
    private FileStorage storage;
    private int id = 1;

    public ToDoService() {
        this.storage = new FileStorage();
        this.todos = storage.getTodos();
    }

    public void addTask(String task) {
        todos.add(new ToDo(task, id++));
        storage.saveTodos(todos);
    }
    public void showAllTasks() {
        for(ToDo todo : todos) {
            System.out.println(todo.toString());
        }
    }
    public void markAsDone(int id) {
        for (ToDo toDo : todos) {
            if (id == toDo.getId()) {
                toDo.markAsDone();
                System.out.println("Task is marked as done");
            }
        }
        storage.saveTodos(todos);
    }
    public void removeTask(int id) {
        todos.removeIf(toDo -> toDo.getId() == id);
        System.out.println("Task removed successfully from todo list");
    }
    public void showDoneTasks() {
        System.out.println("Here's the list of tasks which are done :");
        for (ToDo toDo : todos) {
            if (toDo.isDone()) {
                System.out.println(toDo.toString());
            }
        }
    }
    public void showUnDoneTasks() {
        System.out.println("Here's the list of tasks which are not done yet :");
        for (ToDo toDo : todos) {
            if (!toDo.isDone()) {
                System.out.println(toDo.toString());
            }
        }
    }
}
