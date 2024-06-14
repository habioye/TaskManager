package Hassan.TaskManager.TaskManager.Service;

import Hassan.TaskManager.TaskManager.Entity.Tasks;
import Hassan.TaskManager.TaskManager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public Tasks getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Tasks saveTask(Tasks task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void updateTask(Long id, String task, String description) {
        Tasks taskObject = getTaskById(id);
        if (taskObject == null) return;
        taskObject.task = task;
        taskObject.description = description;
        saveTask(taskObject);


    }


}
