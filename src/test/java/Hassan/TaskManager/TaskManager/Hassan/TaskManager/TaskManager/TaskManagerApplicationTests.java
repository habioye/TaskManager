package Hassan.TaskManager.TaskManager;

import Hassan.TaskManager.TaskManager.Controller.TaskController;
import Hassan.TaskManager.TaskManager.Entity.Tasks;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class TaskManagerApplicationTests {

	@Test
	void contextLoads() {
		Tasks task = new Tasks();
		task.task = "Test";
		task.description  = "Test Description";
		TaskController controller = new TaskController();
		controller.createTask(task);
		Tasks output = controller.getTakskById(task.id);
		assertNotNull(output);
		controller.deleteTask(output.id);
		output = controller.getTakskById(output.id);
		assertNull(output);




	}

}
