package com.example.tasktracker.repository;

import com.example.tasktracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Task entities.
 *
 * Extending JpaRepository provides CRUD operations out of the box:
 * - findAll(), findById(), save(), deleteById(), etc.
 *
 * Spring will automatically generate the implementation at runtime.
 */
@Repository // 🔹 Marks this as a Spring-managed component (optional since JpaRepository already implies it)
public interface TaskRepository extends JpaRepository<Task, Long> {

	// You can define custom query methods here if needed, e.g.:
	// List<Task> findByStatus(String status);

}
