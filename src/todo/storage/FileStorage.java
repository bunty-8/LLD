package todo.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import todo.pojo.ToDo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private static final String FILE_NAME = "resource/todos.json";
    private final Gson gson = new Gson();

    /**
     * method to retrieve tasks from json and converts into java classes
     */
    public List<ToDo> getTodos() {
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            Type listType = new TypeToken<List<ToDo>>() {}.getType();
            List<ToDo> todos = gson.fromJson(fileReader, listType);
            return todos != null ? todos : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("unable to read from json file");
            return new ArrayList<>();
        }
    }

    public void saveTodos(List<ToDo> todos) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(todos, writer);
        } catch (IOException e) {
            System.out.println("unable to write into json file");
        }
    }
}
