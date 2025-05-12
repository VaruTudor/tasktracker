package com.example.tasktracker.model;

import jakarta.persistence.*;       // JPA annotations like @Entity, @Id, etc.
import java.time.LocalDate;        // Java 8+ class for representing dates

/**
 * The Task class represents a task in our task tracker app.
 * It is a JPA entity, which means it will be mapped to a database table.
 */
@Entity // 🔹 Marks this class as a JPA entity (a table in the DB)
public class Task {

	/**
	 * The unique identifier for each task.
	 * The @Id annotation tells JPA this is the primary key.
	 * The @GeneratedValue annotation lets the database auto-generate this value.
	 */
	@Id // 🔹 Primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 🔹 Let the database (like PostgreSQL) auto-increment the ID
	private Long id;

	/**
	 * Title of the task.
	 * This will become a column in the database.
	 */
	private String title;

	/**
	 * Optional description giving more detail about the task.
	 */
	private String description;

	/**
	 * The status of the task.
	 * We'll use strings like "TODO", "IN_PROGRESS", or "DONE" for now.
	 * You could later refactor this to use an enum type.
	 */
	private String status;

	/**
	 * Optional due date for the task.
	 * Stored as a LocalDate (without time).
	 */
	private LocalDate dueDate;

	// --- Constructors ---

	/**
	 * Default constructor is required by JPA.
	 */
	public Task() {}

	/**
	 * Convenience constructor for manually creating Task objects.
	 */
	public Task(String title, String description, String status, LocalDate dueDate) {
		this.title = title;
		this.description = description;
		this.status = status;
		this.dueDate = dueDate;
	}

	// --- Getters and Setters ---

	// These are required so that JPA and Spring can read/write properties.

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
}
