package service;

import dto.TaskDto;
import model.Task;
import model.Status;  
import repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.time.ZoneId;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksSortedByDueDate() {
        return taskRepository.findAllByOrderByDueDateAsc();
    }

    // Mapeando TaskDto para Task
    public Task createTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        
        // Convertendo de Date para LocalDate
        task.setDueDate(taskDto.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        
        // Se status for uma enum, converte a String para a enum Status
        task.setStatus(Status.valueOf(taskDto.getStatus().toUpperCase()));
        
        task.setUserId(taskDto.getUserId());  // Certifique-se de que o campo userId e setUserId existem em Task
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, TaskDto taskDto) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(taskDto.getTitle());
                    task.setDescription(taskDto.getDescription());
                    
                    // Convertendo de Date para LocalDate
                    task.setDueDate(taskDto.getDueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    
                    // Se status for uma enum, converte a String para a enum Status
                    task.setStatus(Status.valueOf(taskDto.getStatus().toUpperCase()));
                    
                    task.setUserId(taskDto.getUserId());
                    return taskRepository.save(task);
                }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
