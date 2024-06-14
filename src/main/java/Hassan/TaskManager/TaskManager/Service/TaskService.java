package Hassan.TaskManager.TaskManager.Service;

import Hassan.TaskManager.TaskManager.Entity.Tasks;
import Hassan.TaskManager.TaskManager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    // Task Reposoitory object
    @Autowired
    private TaskRepository taskRepository;

    // Retrieves all the current task.
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    // retieves the task based on the id.
    public Tasks getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // Saves the task based on the task object
    public Tasks saveTask(Tasks task) {
        return taskRepository.save(task);
    }

    // deletes the task based on id
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // changes the task based on information given
    public void updateTask(Long id, String task, String description) {
        Tasks taskObject = getTaskById(id);
        if (taskObject == null) return;
        taskObject.task = task;
        taskObject.description = description;
        saveTask(taskObject);


    }


}
