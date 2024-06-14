package Hassan.TaskManager.TaskManager.Controller;

import Hassan.TaskManager.TaskManager.Entity.Tasks;
import Hassan.TaskManager.TaskManager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Returns all the tasks in the repository
    @GetMapping
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Below defines CRUD uperations for the database.
    @GetMapping("/get/{id}")
    public Tasks getTakskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("create")
    public Tasks createTask(@RequestBody Tasks task) {
        return taskService.saveTask(task);
    }
    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("update/{id}")
    public void updateTask(@PathVariable Long id, String task, String description) {
        taskService.updateTask(id,task,description);
    }


}
