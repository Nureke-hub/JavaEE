package Week8_Task.springbootdemo.db;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Task> tasks = new ArrayList<>();

    static {
        tasks.add(new Task(1L, "1st", "Output Hello world",  "2020-11-11", true));
        tasks.add(new Task(2L, "2nd", "Output Hello my name is ...",  "2019-12-3", true));
        tasks.add(new Task(3L, "3rd", "Output Java Spring Boot is cool",  "2018-5-12", true));
        tasks.add(new Task(4L, "4th", "Output nege bykil tasktar birdei?",  "2018-4-25", true));
    }
    private static Long id = 5L;
    public static void addTask(Task task){
        task.setId(id);
        tasks.add(task);
        id++;
    }
    public static ArrayList<Task> getTasks(){
        return tasks;
    }

    public static Task getTask(Long id){
        for (Task t: tasks) {
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public static void editTask(Task t){
        Task x = getTask(t.getId());
        x.setName(t.getName());
        x.setDeadlineDate(t.getDeadlineDate());
        x.setDescription(t.getDescription());
        x.setCompleted(t.isCompleted());
    }

    public static void deleteTask(Long id){
        for (Task t: tasks) {
            if(t.getId() == id){
                tasks.remove(t);
                break;
            }
        }
    }
}
