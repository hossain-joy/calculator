# Calculator Application

A full-stack calculator application with a Spring Boot backend and React frontend that supports basic arithmetic operations and maintains calculation history.

## Project Structure

```
calculator/
├── backend/                 # Spring Boot REST API
│   ├── src/main/java/      # Java source code
│   ├── src/main/resources/ # Configuration files
│   └── pom.xml            # Maven dependencies
├── frontend/calculator-ui/ # React frontend
│   ├── src/               # React components
│   ├── package.json       # Node.js dependencies
│   └── vite.config.js     # Vite configuration
└── README.md              # This file
```

## Technologies Used

### Backend
- **Java 21**
- **Spring Boot 3.5.5**
- **Spring Data JPA**
- **PostgreSQL** (Database)
- **Maven** (Build tool)
- **exp4j** (Expression evaluation library)

### Frontend
- **React 19.1.1**
- **Vite** (Build tool)
- **JavaScript/JSX**

## Prerequisites

Before running the application, ensure you have the following installed:

1. **Java Development Kit (JDK) 21**
2. **Maven 3.6+**
3. **Node.js 18+** and **npm**
4. **PostgreSQL 12+**

## Database Setup

1. Install and start PostgreSQL
2. Create a database named `calculator_db`:
   ```sql
   CREATE DATABASE calculator_db;
   ```
3. Update database credentials in `backend/src/main/resources/application.properties` if needed:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/calculator_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   ```

## Installation & Running

### Option 1: Run Both Services Separately

#### Backend (Spring Boot API)
1. Navigate to the backend directory:
   ```bash
   cd backend
   ```

2. Install dependencies and run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   
   Or using the Maven wrapper:
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

3. The backend API will be available at: `http://localhost:8080`

#### Frontend (React App)
1. Navigate to the frontend directory:
   ```bash
   cd frontend/calculator-ui
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm run dev
   ```

4. The frontend will be available at: `http://localhost:5173`

### Option 2: Quick Start Script

Create a batch file to start both services:

**start-app.bat** (Windows):
```batch
@echo off
echo Starting Calculator Application...

echo Starting Backend...
start cmd /k "cd backend && mvnw spring-boot:run"

echo Waiting for backend to start...
timeout /t 10

echo Starting Frontend...
start cmd /k "cd frontend/calculator-ui && npm run dev"

echo Application started!
echo Backend: http://localhost:8080
echo Frontend: http://localhost:5173
```

## API Endpoints

The backend provides the following REST endpoints:

- `POST /api/calculator/calculate` - Perform calculation
- `GET /api/calculator/history` - Get calculation history

## Features

- **Basic Arithmetic Operations**: Addition, subtraction, multiplication, division
- **Expression Evaluation**: Supports complex mathematical expressions
- **Calculation History**: Stores and displays previous calculations
- **Responsive UI**: Clean and intuitive calculator interface
- **Real-time Updates**: History updates automatically after each calculation

## Development

### Backend Development
- Main application: `backend/src/main/java/com/example/calculator/CalculatorApplication.java`
- Controller: `backend/src/main/java/com/example/calculator/controller/CalculatorController.java`
- Service: `backend/src/main/java/com/example/calculator/service/CalculatorService.java`

### Frontend Development
- Main component: `frontend/calculator-ui/src/App.jsx`
- Calculator component: `frontend/calculator-ui/src/components/Calculator.jsx`
- History component: `frontend/calculator-ui/src/components/History.jsx`

### Building for Production

#### Backend
```bash
cd backend
mvn clean package
java -jar target/calculator-0.0.1-SNAPSHOT.jar
```

#### Frontend
```bash
cd frontend/calculator-ui
npm run build
npm run preview
```

## Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Ensure PostgreSQL is running
   - Verify database credentials in `application.properties`
   - Check if `calculator_db` database exists

2. **Port Already in Use**
   - Backend (8080): Change `server.port` in `application.properties`
   - Frontend (5173): Vite will automatically use the next available port

3. **CORS Issues**
   - Ensure backend is running on `localhost:8080`
   - Check API_URL in `frontend/calculator-ui/src/App.jsx`

4. **Maven/Node Dependencies**
   - Run `mvn clean install` for backend
   - Run `npm install` for frontend

## License

This project is for educational purposes.