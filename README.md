# Book Management Microservice

A Spring Boot microservice for managing books, authors, and reviews with full CRUD operations.

## Features

- **Authors Management**: Create, Read, Update, Delete authors
- **Books Management**: Create, Read, Update, Delete books with author association
- **Reviews Management**: Create, Read, Update, Delete reviews for books
- **In-Memory Storage**: Simple in-memory data storage for quick testing
- **RESTful API**: Clean REST endpoints for all operations

## Technology Stack

- Java 17
- Spring Boot 3.2.1
- Maven
- In-memory storage (ConcurrentHashMap)

## Building the Project

```bash
mvn clean package
```

## Running the Application

```bash
java -jar target/book-management-1.0.0.jar
```

The application will start on `http://localhost:8080`

## API Endpoints

### Authors

- **GET** `/api/authors` - Get all authors
- **GET** `/api/authors/{id}` - Get author by ID
- **POST** `/api/authors` - Create a new author
- **PUT** `/api/authors/{id}` - Update an author
- **DELETE** `/api/authors/{id}` - Delete an author

### Books

- **GET** `/api/books` - Get all books
- **GET** `/api/books?authorId={authorId}` - Get books by author
- **GET** `/api/books/{id}` - Get book by ID
- **POST** `/api/books` - Create a new book
- **PUT** `/api/books/{id}` - Update a book
- **DELETE** `/api/books/{id}` - Delete a book

### Reviews

- **GET** `/api/reviews` - Get all reviews
- **GET** `/api/reviews?bookId={bookId}` - Get reviews by book
- **GET** `/api/reviews/{id}` - Get review by ID
- **POST** `/api/reviews` - Create a new review
- **PUT** `/api/reviews/{id}` - Update a review
- **DELETE** `/api/reviews/{id}` - Delete a review

## Example Usage

### Create an Author

```bash
curl -X POST http://localhost:8080/api/authors \
  -H "Content-Type: application/json" \
  -d '{"name":"J.K. Rowling","biography":"British author best known for the Harry Potter series"}'
```

### Create a Book

```bash
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"title":"Harry Potter and the Philosophers Stone","isbn":"978-0747532699","authorId":1,"description":"A young wizard begins his journey"}'
```

### Create a Review

```bash
curl -X POST http://localhost:8080/api/reviews \
  -H "Content-Type: application/json" \
  -d '{"bookId":1,"reviewerName":"John Doe","rating":5,"comment":"Absolutely magical! A must-read."}'
```

### Get All Authors

```bash
curl http://localhost:8080/api/authors
```

### Update a Book

```bash
curl -X PUT http://localhost:8080/api/books/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Harry Potter and the Philosophers Stone","isbn":"978-0747532699","authorId":1,"description":"Updated description"}'
```

### Delete a Review

```bash
curl -X DELETE http://localhost:8080/api/reviews/1
```

## Data Models

### Author
```json
{
  "id": 1,
  "name": "J.K. Rowling",
  "biography": "British author best known for the Harry Potter series",
  "bookIds": []
}
```

### Book
```json
{
  "id": 1,
  "title": "Harry Potter and the Philosophers Stone",
  "isbn": "978-0747532699",
  "authorId": 1,
  "description": "A young wizard begins his journey",
  "reviewIds": []
}
```

### Review
```json
{
  "id": 1,
  "bookId": 1,
  "reviewerName": "John Doe",
  "rating": 5,
  "comment": "Absolutely magical! A must-read."
}
```

## Project Structure

```
src/
├── main/
│   ├── java/com/example/bookmanagement/
│   │   ├── BookManagementApplication.java
│   │   ├── controller/
│   │   │   ├── AuthorController.java
│   │   │   ├── BookController.java
│   │   │   └── ReviewController.java
│   │   ├── model/
│   │   │   ├── Author.java
│   │   │   ├── Book.java
│   │   │   └── Review.java
│   │   ├── repository/
│   │   │   ├── AuthorRepository.java
│   │   │   ├── BookRepository.java
│   │   │   └── ReviewRepository.java
│   │   └── service/
│   │       ├── AuthorService.java
│   │       ├── BookService.java
│   │       └── ReviewService.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/example/bookmanagement/
```