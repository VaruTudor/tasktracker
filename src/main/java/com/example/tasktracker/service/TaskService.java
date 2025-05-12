package com.example.tasktracker.service;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing Task-related business logic.
 * This layer talks to the repository and is called by the controller.
 */
@Service // 🔹 Marks this class as a Spring service component (it will be auto-discovered)
public class TaskService {

	private final TaskRepository taskRepository;

	/**
	 * Constructor injection of the repository.
	 * Spring automatically injects the TaskRepository bean here.
	 */
	@Autowired // 🔹 Not strictly required with one constructor, but useful for clarity
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	/**
	 * Get all tasks from the database.
	 */
	public List<Task> getAllTasks() {
		return taskRepository.findAll(); // Provided by JpaRepository
	}

	/**
	 * Get a single task by ID.
	 * Returns Optional<Task> so caller can handle "not found".
	 */
	public Optional<Task> getTaskById(Long id) {
		return taskRepository.findById(id); // Provided by JpaRepository
	}

	/**
	 * Create a new task or update an existing one.
	 * If the task has an ID, JPA will treat it as an update.
	 */
	public Task saveTask(Task task) {
		return taskRepository.save(task); // Provided by JpaRepository
	}

	/**
	 * Delete a task by its ID.
	 */
	public void deleteTask(Long id) {
		taskRepository.deleteById(id); // Provided by JpaRepository
	}
}
