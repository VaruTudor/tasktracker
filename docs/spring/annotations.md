# Spring Annotations Explained

## @RestController
Used to mark a class as a controller that returns data (usually JSON). It combines the `@Controller` and `@ResponseBody` annotations, which allow the class to handle HTTP requests and return responses directly without needing a view.

Equivalent to: @Controller + @ResponseBody

## @Service
Marks a class as a business logic service. Typically used for non-UI components and managed by Spring. It’s a special type of `@Component`, which makes it eligible for component scanning and dependency injection.

## @Repository
Marks a class or interface that handles data access. It is a specialized `@Component` for persisting entities. It also enables exception translation, which means that Spring will automatically convert database-related exceptions (like `SQLException`) into runtime exceptions.

## @Entity
Marks a class as an entity that will be persisted to the database. It represents a table in the database, with each instance of the class corresponding to a row in the table.

## @Id
Marks the primary key of the entity. This is required to identify the unique record in the table.

## @GeneratedValue
Specifies how the primary key should be generated. For example, it can auto-generate values for the primary key.

## @Autowired
Marks a constructor, field, or setter to be injected with a Spring-managed bean. Spring automatically resolves the dependency.

## @RequestMapping
Defines a URL path that should be mapped to a controller method. It can handle different HTTP methods (`GET`, `POST`, etc.). While `@GetMapping`, `@PostMapping`, etc., are often preferred for readability, `@RequestMapping` can be used for more fine-grained control.

## @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
Shortcut annotations for specific HTTP methods. They are shorthand for `@RequestMapping` with specific HTTP methods like `GET`, `POST`, `PUT`, and `DELETE`.

## @PathVariable
Extracts a value from the URL path and maps it to a method parameter. This is useful when you want to pass dynamic data as part of the URL.

## @RequestBody
Binds the HTTP request body to a Java object. It is often used in `POST` or `PUT` requests to pass complex objects (like JSON) to your methods.

## @ResponseEntity
Represents the whole HTTP response, including status code, headers, and body. It is used to send a response with a specific HTTP status and content.

## @Value
Injects property values from application properties or YAML files into a Spring bean.
