<h2>BACKEND-TASK-TRACKER</h2>

<h3>Overview</h3> 
<p></p>backend-task-tracker is a comprehensive backend solution for managing tasks and task lists, built on Spring boot and PostgreSQL. It provides a scalable, modular architecture designed to facilitate efficient task organization, monitoring, and data management.</p>

<h3>Why backend-task-tracker?</h3>

<p>This project streamlines task management with a focus on reliability and scalability. The core features include:</p>

 RESTful Endpoints: Create, retrieve, update, and delete tasks and task lists with ease.
 Data Mapping: Seamless transformation between entities and DTOs for clean data flow.
 Centralized Error Handling: Consistent and user-friendly error responses.
 Containerized PostgreSQL: Simplified setup with Docker Compose for consistent development environments.
 Spring Boot Foundation: Modular, maintainable, and ready for extension.
 Task Progress & Status: Built-in support for task statuses and progress tracking.

<h3>Getting Started:</h3

<h3>Prerequisites:</h3>

<h3>This project requires the following dependencies:</h3>

 Programming Language: Java
 Package Manager: Maven
 Container Runtime: Docker

Installation

 Build backend-task-tracker from the source and install dependencies:
 
 1. Clone the repository:
  
  **https://github.com/Bezy427/backend-task-tracker.git**

 2. Navigate to the project directory:
 
  **https://github.com/Bezy427/backend-task-tracker.git**

 3. Install the dependencies:

  Using **docker**

  Using **maven**
  
  Usage:
 
 <h4>Run the project with:</h4>

  <h4>Run Locally with Docker:</h4>
 
  ```
  bash
  docker-compose up --build
  ```
  Using **maven**

 <h3>API Testing using Postman:</h3>

  ```
 GET /task-lists/{task_list_id}/tasks
  ```
  ```
 GET /task-lists
  ```
  ```
 POST /task-lists
  ```
  ```
 GET /task-lists/{task_lists_id}
  ```

  ```
 POST /task-lists/{task-list-id}
  ```

  ```
 PUT /task-lists/{task_list_id}
  ```
