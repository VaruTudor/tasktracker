package com.example.tasktracker.controller;

import com.example.tasktracker.model.Task;
import com.example.tasktracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller that handles HTTP requests for Task-related actions.
 * It delegates business logic to the TaskService.
 */
@CrossOrigin(origins = "*")
@RestController // 🔹 Tells Spring this class will handle REST API requests (JSON in, JSON out)
@RequestMapping("/api/tasks") // 🔹 Base URL path for all task-related endpoints
public class TaskController {

	private final TaskService taskService;

	/**
	 * Constructor injection for the TaskService.
	 */
	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	/**
	 * GET /api/tasks
	 * Returns a list of all tasks.
	 */
	@GetMapping
	public List<Task> getAllTasks() {
		return taskService.getAllTasks();
	}

	/**
	 * GET /api/tasks/{id}
	 * Returns a single task by ID, or 404 if not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
		return taskService.getTaskById(id)
				.map(ResponseEntity::ok) // If task found, return 200 OK with body
				.orElse(ResponseEntity.notFound().build()); // Else return 404
	}

	/**
	 * POST /api/tasks
	 * Creates a new task.
	 */
	@PostMapping
	public Task createTask(@RequestBody Task task) {
		return taskService.saveTask(task); // No ID yet, so treated as new
	}

	/**
	 * PUT /api/tasks/{id}
	 * Updates an existing task (if found).
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
		return taskService.getTaskById(id)
				.map(existingTask -> {
					// Update fields manually
					existingTask.setTitle(updatedTask.getTitle());
					existingTask.setDescription(updatedTask.getDescription());
					existingTask.setStatus(updatedTask.getStatus());
					existingTask.setDueDate(updatedTask.getDueDate());
					return ResponseEntity.ok(taskService.saveTask(existingTask));
				})
				.orElse(ResponseEntity.notFound().build());
	}

	/**
	 * DELETE /api/tasks/{id}
	 * Deletes the task with the given ID.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		if (taskService.getTaskById(id).isPresent()) {
			taskService.deleteTask(id);
			return ResponseEntity.noContent().build(); // 204 No Content
		} else {
			return ResponseEntity.notFound().build(); // 404
		}
	}
}
