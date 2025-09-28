# mower - Automatic Lawn Mower Simulation

A Spring Boot REST API that simulates autonomous lawn mowers navigating rectangular fields.

## Overview
This application simulates automatic lawn mowers that can be programmed to navigate rectangular lawns. Each mower has:

Position: (x,y) coordinates on the field

Orientation: Cardinal direction (N, E, S, W)

Instructions: Commands to move forward (A) or turn left/right (G/D)

## Features
- ✅ RESTful API for mower simulation
- ✅ Multiple mower support with sequential execution
- ✅ Boundary validation (mowers can't leave the field)
- ✅ Input validation with error handling
- ✅ Comprehensive test coverage


## Quick start
### Environment and technology stack
- Java 21 Devcontainer `mcr.microsoft.com/devcontainers/java:1-21-bullseye`
- Spring Boot 3.5.6
- Spring Web (REST API)
- Spring Validation (Input validation)
- Spring Boot Test (Testing framework)
- JUnit 5 (Unit testing)
- Maven (Build tool)

### Run the application
```bash
# Clone the repository
git clone https://github.com/amal2222/mower.git
cd mower

# Run the application
mvn spring-boot:run
```
The application will start on `http://localhost:8080`

### Test the API
#### Simulate mowers:
```bash
curl -X POST http://localhost:8080/api/mowers/simulate \
  -H "Content-Type: application/json" \
  -d '{
    "field": {
      "max_x": 5,
      "max_y": 5
    },
    "mowers": [
      {
        "id": "mower1",
        "start_position": {
          "x": 1,
          "y": 2
        },
        "orientation": "N",
        "instructions": ["G", "A", "G", "A", "G", "A", "G", "A", "A"]
      }
    ]
  }'
  ```
#### Expected response:

```json
[
  {
    "id": "mower1",
    "position": {
      "x": 1,
      "y": 3
    },
    "orientation": "N"
  }
]
```
## API Documentation
### Endpoint
`POST /api/mowers/simulate`

### Request format
```json
{
  "field": {
    "max_x": 5,
    "max_y": 5
  },
  "mowers": [
    {
      "id": "string",
      "start_position": {
        "x": 0,
        "y": 0
      },
      "orientation": "N|E|S|W",
      "instructions": ["G", "D", "A"]
    }
  ]
}
```

### Instructions
```
G: Turn left 90°
D: Turn right 90°
A: Move forward one position
```

### Response Format
```json
[
  {
    "id": "string",
    "position": {
      "x": 0,
      "y": 0
    },
    "orientation": "N|E|S|W"
  }
]
```
## Project structure
```
src/main/java/com/libon/mower/
├── controller/         # REST API endpoints
├── service/            # Business logic
├── domain/             # Core entities (Mower, Field, Position)
├── dto/                # Data transfer objects
└── exception/          # Error handling
```
## Testing
### Run all tests
```bash
mvn test
```
### Unit tests
```bash
mvn test -Dtest=OrientationTest
mvn test -Dtest=MowerTest
```
### Integration tests
```bash
mvn test -Dtest=MowerControllerIntegrationTest
```