package Hassan.TaskManager.TaskManager.Repository;

import Hassan.TaskManager.TaskManager.Entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {

}
