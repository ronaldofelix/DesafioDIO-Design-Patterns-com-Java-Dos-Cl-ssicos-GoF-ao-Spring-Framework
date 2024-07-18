package one.dioinnovation.gerenciadortasks.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found"));
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
    
}
