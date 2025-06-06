## Task Manager  Application
A simple Task Manager application built using Spring Boot , Thymeleaf , and H2 Database . This application allows users to create, read, update, and delete tasks with an intuitive UI. It also includes Docker support for containerization and deployment.

## Features
- CRUD Operations : Create, Read, Update, and Delete tasks.
- Intuitive UI : Bootstrap-styled frontend for a clean user experience.
- In-Memory Database : Uses H2 database for development and testing.
- Containerization : Includes a Dockerfile for building and running the application in a Docker container.
- GitHub Actions Integration : Automates Docker image builds and pushes to Amazon ECR.


## Getting Started
### Local Setup
Clone the Repository :
```bash
git clone https://github.com/AbuduSamadu/task-management.git

cd task-manager
```
Build the Project :
```bash
mvn clean package

mvn clean install
```

Run the Application :
```bash
mvn spring-boot:run
```

Access the Application :
Open your browser and navigate to:
```bash
http://localhost:5000

```
Access H2 Console (Optional) :
Navigate to:
```bash
http://localhost:5000/h2-console
```

Build the Docker Image :
```bash
docker build -t task-manager:latest .
```

Run the Docker Container :
```bash
docker run -p 5000:5000 task-manager:latest

```
Access the Application :

Open your browser and navigate to:
```` http://localhost:8080````

##  Usage

- **Add a Task**:
    - Click the "Add New Task" button on the home page.
    - Fill in the task details (title, description, due date) and submit.

- **Edit a Task**:
    - Click the "Edit" button next to a task.
    - Update the task details and save.

- **Delete a Task**:
    - Click the "Delete" button next to a task to remove it.

##  Deployment

### Deploying to Amazon ECS

1. **Push Docker Image to ECR**:
   Follow the steps in the GitHub Actions workflow to push the Docker image to Amazon Elastic Container Registry (ECR).

2. **Deploy to ECS**:
    - Create an ECS cluster, task definition, and service.
    - Use the pushed Docker image as the container image in the task definition.

##  Contributing
We welcome contributions! To contribute:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a pull request.

##  License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Acknowledgments
- Built with Spring Boot, Thymeleaf, and H2 Database.
- Styled using Bootstrap for a responsive UI.
- Containerized with Docker for easy deployment.