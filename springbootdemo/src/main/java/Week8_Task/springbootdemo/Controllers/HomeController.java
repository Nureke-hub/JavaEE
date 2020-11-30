package Week8_Task.springbootdemo.Controllers;

import Week8_Task.springbootdemo.db.DBManager;
import Week8_Task.springbootdemo.db.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Task> tasks = DBManager.getTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    @PostMapping(value = "/add_task")
    public String addTask(@RequestParam(name = "name", defaultValue = "No name") String name,
                          @RequestParam(name = "description", defaultValue = "No description") String description,
                          @RequestParam(name = "deadline_date", defaultValue = "Empty") String date,
                          @RequestParam(name = "is_completed", defaultValue = "false") String is_completed){

        DBManager.addTask(new Task(null, name, description, date, new Boolean(is_completed)));

        return "redirect:/";
    }


    @PostMapping(value = "/edit")
    public String edit(@RequestParam(name = "name", defaultValue = "No name") String name,
                          @RequestParam(name = "description", defaultValue = "No description") String description,
                          @RequestParam(name = "deadline_date", defaultValue = "Empty") String date,
                          @RequestParam(name = "is_completed", defaultValue = "false") String is_completed,
                          @RequestParam(name = "id") Long id){

        Task t = new Task(id, name, description, date,  new Boolean(is_completed));
        DBManager.editTask(t);
        return "redirect:/";
    }


    @GetMapping(value = "/details/{idshka}")
    public String details(Model model, @PathVariable(name = "idshka") Long id){
        Task task = DBManager.getTask(id);
        model.addAttribute("task", task);
        return "details";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(name = "id") Long id){
        DBManager.deleteTask(id);
        return "redirect:/";
    }
}

