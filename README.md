# Task Tracker – Spring Boot Learning Project

A simple REST API to manage tasks. This project is built with Java, Spring Boot, and follows best practices for learning full-stack backend development.

---

## 🧠 Key Spring Concepts (with annotations)

### 📍 Model Layer (`Task.java`)
- `@Entity`: Maps the class to a DB table.
- `@Id`: Marks the primary key.
- `@GeneratedValue`: Auto-generates ID.
- Uses `LocalDate` for date-only values.

---

### 📍 Repository Layer (`TaskRepository.java`)
- Extends `JpaRepository<Task, Long>` to get:
    - `findAll()`, `findById()`, `save()`, `deleteById()`, etc.
- `@Repository`: Marks it as a Spring Data component (optional if extending JpaRepository).

---

### 📍 Service Layer (`TaskService.java`)
- `@Service`: Marks it as a business logic component.
- Uses **constructor injection** with `@Autowired`.
- Uses `Optional<Task>` for null-safe queries.

---

### 📍 Controller Layer (`TaskController.java`)
- `@RestController`: Combines `@Controller` + `@ResponseBody`.
- `@RequestMapping("/api/tasks")`: Base path for routes.
- `@GetMapping`, `@PostMapping`, etc.: Maps HTTP methods.
- `@PathVariable`: Injects dynamic values from URL.
- `@RequestBody`: Converts JSON to Java objects.
- `ResponseEntity`: Allows flexible HTTP responses (status + body).

---

## 💡 Learning Goals
- Understand layered architecture (Controller → Service → Repository → DB).
- Practice Java basics (constructors, getters/setters, types).
- Learn Spring Boot and REST APIs.
- Prepare for integration with Docker and PostgreSQL.

---

## 🚀 Run the Project
_TBD: Add details once PostgreSQL or H2 is configured._

