#  TestCase API Documentation

This project provides a simple **TestCase Management API** that allows you to create, retrieve, update, and delete test cases.

**Base URL:** `http://localhost:8080`

---

##  API Endpoints

### 1) Create a New TestCase

**Request**
```http
POST http://localhost:8080/api/testcases
Content-Type: application/json

{
  "name": "Login Functionality Test",
  "description": "Verify that user can log in with valid credentials",
  "status": "ACTIVE",
  "testType": "UI"
}

```
**Response**
```http
{
  "name": "Login Functionality Test",
  "description": "Verify that user can log in with valid credentials",
  "status": "ACTIVE",
  "testType": "UI"
}

```

### 2) Get All TestCases

**Request**
```http
GET http://localhost:8080/api/testcases
```

**Response**
```http

[
  {
    "id": 1,
    "name": "Login Functionality Test",
    "description": "Verify that user can log in with valid credentials",
    "status": "ACTIVE",
    "testType": "UI"
  }
]
```

### 3) Get TestCase by ID
**Request**
```http
GET http://localhost:8080/api/testcases/{id}
```

**Response**
```http

{
  "id": 1,
  "name": "Login Functionality Test",
  "description": "Verify that user can log in with valid credentials",
  "status": "ACTIVE",
  "testType": "UI"
}
```


### 4) Update TestCase
**Request**
```http
PUT http://localhost:8080/api/testcases/{id}
Content-Type: application/json
```

**Response**
```http
{
  "name": "Login Flow Test",
  "description": "Verify that user can log in with valid & invalid credentials",
  "status": "ACTIVE",
  "testType": "API"
}
```

### 5) Delete TestCase
**Request**
```http
DELETE http://localhost:8080/api/testcases/{id}
```

**Response Body (204 No Content)**
```http
 no response 
```

**Verify Deletion**
```http
GET http://localhost:8080/api/testcases/{id}
```

**Response**
```http
{
  "error": "TestCase not found with id 1"
}
```
---
## TEST RESULTS
### 1) Create a New TestResult

**Request**
```http
POST http://localhost:8080/api/testresults
Content-Type: application/json

{
  "status": "PASSED",
  "executedAt": "2025-08-27T14:30:00",
  "testCase": {
    "id": 1
  }
}
```

**Response**
```http
{
  "id": 1,
  "status": "PASSED",
  "executedAt": "2025-08-27T14:30:00",
  "testCase": {
    "id": 1,
    "name": "Login Functionality Test",
    "description": "Verify that user can log in with valid credentials",
    "status": "ACTIVE",
    "testType": "UI"
  }
}
```
### 2) Get All TestResults
**Request**
```http
GET http://localhost:8080/api/testresults
```
**Response**
```http
{
  "id": 1,
  "status": "PASSED",
  "executedAt": "2025-08-27T14:30:00",
  "testCase": {
    "id": 1,
    "name": "Login Functionality Test",
    "description": "Verify that user can log in with valid credentials",
    "status": "ACTIVE",
    "testType": "UI"
  }
}
```

### 3) Get TestResult by ID
**Request**
```http
GET http://localhost:8080/api/testresults/1
```
**Response**
```http
{
  "id": 1,
  "status": "PASSED",
  "executedAt": "2025-08-27T14:30:00",
  "testCase": {
    "id": 1,
    "name": "Login Functionality Test",
    "description": "Verify that user can log in with valid credentials",
    "status": "ACTIVE",
    "testType": "UI"
  }
}
```

### 4) Get All TestResults for a Given TestCase
**Request**
```http
GET http://localhost:8080/api/testresults/testcase/1
```
**Response**
```http
{
  "id": 1,
  "status": "PASSED",
  "executedAt": "2025-08-27T14:30:00",
  "testCase": {
    "id": 1,
    "name": "Login Functionality Test",
    "description": "Verify that user can log in with valid credentials",
    "status": "ACTIVE",
    "testType": "UI"
  }
}
```
### 5) Update TestResult

**Request**
```http
PUT http://localhost:8080/api/testresults/1
Content-Type: application/json

{
  "status": "FAILED",
  "executedAt": "2025-08-27T15:00:00",
  "testCase": {
    "id": 1
  }
}
```


**Response**
```http
{
  "id": 1,
  "status": "FAILED",
  "executedAt": "2025-08-27T15:00:00",
  "testCase": {
    "id": 1,
    "name": "Login Functionality Test",
    "description": "Verify that user can log in with valid credentials",
    "status": "ACTIVE",
    "testType": "UI"
  }
}
```

### 6) Delete TestResult

**Request**
```http
DELETE http://localhost:8080/api/testresults/1
```
**Response Body (204 No Content)**
```http
 no response 
```
**Verify Deletion**
**Request**
```http
GET http://localhost:8080/api/testresults/1
```
**Response Body (204 No Content)**
```http
{
  "error": "TestResult not found with id 1"
} 
```






