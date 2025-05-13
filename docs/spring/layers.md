# Layered Architecture in Spring

## Controller Layer
- Exposes HTTP endpoints to the client.
- Calls the service layer to handle business logic.

## Service Layer
- Contains business logic.
- Interacts with the repository to fetch or store data.

## Repository Layer
- Interfaces with the database via Spring Data JPA.
- Handles CRUD operations for the model objects.
