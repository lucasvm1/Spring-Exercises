# Library Management System API Documentation

This documentation details all available endpoints in the Library Management System REST API, including parameters, request formats, and responses.

## Summary

- [Authors](#authors)
- [Books](#books)
- [Users](#users)
- [Loans](#loans)

## Authors

### List all authors

**Endpoint:** `GET /authors`

**Description:** Returns a list of all authors registered in the system.

**Success Response:**
- **Code:** 200 OK
- **Content:**
```json
[
  {
    "id": "5236c284-c7b8-45fc-a18a-e542b219faff",
    "name": "Machado de Assis",
    "biography": "Joaquim Maria Machado de Assis was a Brazilian writer...",
    "nationality": "BR",
    "birthDate": "1839-06-21",
    "books": []
  },
  {
    "id": "7d9f0386-f336-42c0-b9f0-c3b28d46a0a5",
    "name": "Jane Austen",
    "biography": "Jane Austen was an English novelist...",
    "nationality": "UK",
    "birthDate": "1775-12-16",
    "books": []
  }
]
```

### Get author by ID

**Endpoint:** `GET /authors/{id}`

**Parameters:**
- `id` (path): Author's UUID

**Success Response:**
- **Code:** 200 OK
- **Content:**
```json
{
  "id": "5236c284-c7b8-45fc-a18a-e542b219faff",
  "name": "Machado de Assis",
  "biography": "Joaquim Maria Machado de Assis was a Brazilian writer...",
  "nationality": "BR",
  "birthDate": "1839-06-21",
  "books": [
    {
      "id": "a1b2c3d4-e5f6-48a9-b7c8-d9e0f1a2b3c4",
      "title": "Dom Casmurro",
      "isbn": "9788574801414",
      "genre": "Novel",
      "year": 1899,
      "isAvailable": true
    }
  ]
}
```

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response

### Add new author

**Endpoint:** `POST /authors`

**Request Body:**
```json
{
  "name": "George Orwell",
  "biography": "Eric Arthur Blair, known by his pen name George Orwell, was an English novelist, essayist, journalist, and critic.",
  "nationality": "UK",
  "birthDate": "1903-06-25"
}
```

**Validations:**
- `name`: Not blank, between 3 and 100 characters
- `biography`: Not blank, maximum 256 characters
- `nationality`: Not blank, exactly 2 characters (country code)
- `birthDate`: Not null, must be a date in the past

**Success Response:**
- **Code:** 201 Created
- **Headers:** `Location: /authors/{id}`
- **Content:** The created author with its ID

**Error Response:**
- **Code:** 400 Bad Request
- **Content:** Details of the validation that failed

### Update author

**Endpoint:** `PUT /authors/{id}`

**Parameters:**
- `id` (path): Author's UUID

**Request Body:**
```json
{
  "name": "George Orwell",
  "biography": "Eric Arthur Blair, known by his pen name George Orwell, was an English novelist, essayist, journalist, and critic.",
  "nationality": "UK",
  "birthDate": "1903-06-25"
}
```

**Success Response:**
- **Code:** 200 OK
- **Content:** The updated author

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response
- **Code:** 400 Bad Request
- **Content:** Details of the validation that failed

### Delete author

**Endpoint:** `DELETE /authors/{id}`

**Parameters:**
- `id` (path): Author's UUID

**Success Response:**
- **Code:** 204 No Content
- **Content:** Empty response

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response

## Books

### List all books

**Endpoint:** `GET /books`

**Description:** Returns a list of all books registered in the system.

**Success Response:**
- **Code:** 200 OK
- **Content:**
```json
[
  {
    "id": "a1b2c3d4-e5f6-48a9-b7c8-d9e0f1a2b3c4",
    "title": "Dom Casmurro",
    "author": {
      "id": "5236c284-c7b8-45fc-a18a-e542b219faff",
      "name": "Machado de Assis"
    },
    "isbn": "9788574801414",
    "genre": "Novel",
    "year": 1899,
    "isAvailable": true
  },
  {
    "id": "b2c3d4e5-f6a7-59b0-c8d9-e0f1a2b3c4d5",
    "title": "1984",
    "author": {
      "id": "8e9f0ad7-g447-53d1-c0a1-d4b2a3b5c6d7",
      "name": "George Orwell"
    },
    "isbn": "9780451524935",
    "genre": "Dystopian Fiction",
    "year": 1949,
    "isAvailable": true
  }
]
```

### Get book by ID

**Endpoint:** `GET /books/{id}`

**Parameters:**
- `id` (path): Book's UUID

**Success Response:**
- **Code:** 200 OK
- **Content:**
```json
{
  "id": "a1b2c3d4-e5f6-48a9-b7c8-d9e0f1a2b3c4",
  "title": "Dom Casmurro",
  "author": {
    "id": "5236c284-c7b8-45fc-a18a-e542b219faff",
    "name": "Machado de Assis"
  },
  "isbn": "9788574801414",
  "genre": "Novel",
  "year": 1899,
  "isAvailable": true
}
```

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response

### Add new book

**Endpoint:** `POST /books`

**Request Body:**
```json
{
  "title": "Memórias Póstumas de Brás Cubas",
  "authorId": "5236c284-c7b8-45fc-a18a-e542b219faff",
  "isbn": "9788542221084",
  "genre": "Novel",
  "year": 1881
}
```

**Validations:**
- `title`: Not blank, between 3 and 50 characters
- `authorId`: Not null, must be an existing author's UUID
- `isbn`: Not blank
- `genre`: Not blank
- `year`: Must be positive

**Success Response:**
- **Code:** 201 Created
- **Headers:** `Location: /books/{id}`
- **Content:** The created book with its ID

**Error Response:**
- **Code:** 400 Bad Request
- **Content:** Details of the validation that failed
- **Code:** 404 Not Found
- **Content:** Empty response (if the author doesn't exist)

### Update book

**Endpoint:** `PUT /books/{id}`

**Parameters:**
- `id` (path): Book's UUID

**Request Body:**
```json
{
  "title": "Memórias Póstumas de Brás Cubas",
  "authorId": "5236c284-c7b8-45fc-a18a-e542b219faff",
  "isbn": "9788542221084",
  "genre": "Novel",
  "year": 1881
}
```

**Success Response:**
- **Code:** 200 OK
- **Content:** The updated book

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response
- **Code:** 400 Bad Request
- **Content:** Details of the validation that failed

### Delete book

**Endpoint:** `DELETE /books/{id}`

**Parameters:**
- `id` (path): Book's UUID

**Success Response:**
- **Code:** 204 No Content
- **Content:** Empty response

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response

## Users

### List all users

**Endpoint:** `GET /users`

**Description:** Returns a list of all users registered in the system.

**Success Response:**
- **Code:** 200 OK
- **Content:**
```json
[
  {
    "id": "c3d4e5f6-a7b8-69c0-d9e0-f1a2b3c4d5e6",
    "name": "John Smith",
    "email": "john.smith@email.com",
    "phone": "11987654321",
    "address": "123 Flower Street",
    "registrationDate": "2023-01-15"
  },
  {
    "id": "d4e5f6a7-b8c9-70d1-e0f1-a2b3c4d5e6f7",
    "name": "Mary Johnson",
    "email": "mary.johnson@email.com",
    "phone": "11998765432",
    "address": "1000 Main Avenue",
    "registrationDate": "2023-02-20"
  }
]
```

### Get user by ID

**Endpoint:** `GET /users/{id}`

**Parameters:**
- `id` (path): User's UUID

**Success Response:**
- **Code:** 200 OK
- **Content:**
```json
{
  "id": "c3d4e5f6-a7b8-69c0-d9e0-f1a2b3c4d5e6",
  "name": "John Smith",
  "email": "john.smith@email.com",
  "phone": "11987654321",
  "address": "123 Flower Street",
  "registrationDate": "2023-01-15"
}
```

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response

### Create user

**Endpoint:** `POST /users`

**Request Body:**
```json
{
  "name": "Peter Williams",
  "email": "peter.williams@email.com",
  "phone": "11976543210",
  "address": "500 Pine Street"
}
```

**Validations:**
- `name`: Not blank
- `email`: Not blank, must be a valid email
- `phone`: Not blank, between 7 and 20 characters
- `address`: Not blank

**Success Response:**
- **Code:** 201 Created
- **Headers:** `Location: /users/{id}`
- **Content:** The created user with its ID

**Error Response:**
- **Code:** 400 Bad Request
- **Content:** Details of the validation that failed

### Update user

**Endpoint:** `PUT /users/{id}`

**Parameters:**
- `id` (path): User's UUID

**Request Body:**
```json
{
  "name": "Peter Williams",
  "email": "peter.williams.updated@email.com",
  "phone": "11976543210",
  "address": "500 Pine Street, Apt 42"
}
```

**Success Response:**
- **Code:** 200 OK
- **Content:** The updated user

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response
- **Code:** 400 Bad Request
- **Content:** Details of the validation that failed

### Delete user

**Endpoint:** `DELETE /users/{id}`

**Parameters:**
- `id` (path): User's UUID

**Success Response:**
- **Code:** 204 No Content
- **Content:** Empty response

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response

## Loans

### List all loans

**Endpoint:** `GET /loans`

**Description:** Returns a list of all loans made.

**Success Response:**
- **Code:** 200 OK
- **Content:**
```json
[
  {
    "id": "e5f6a7b8-c9d0-81e1-f2a3-b4c5d6e7f8a9",
    "book": {
      "id": "a1b2c3d4-e5f6-48a9-b7c8-d9e0f1a2b3c4",
      "title": "Dom Casmurro",
      "author": {
        "id": "5236c284-c7b8-45fc-a18a-e542b219faff",
        "name": "Machado de Assis"
      }
    },
    "user": {
      "id": "c3d4e5f6-a7b8-69c0-d9e0-f1a2b3c4d5e6",
      "name": "John Smith",
      "email": "john.smith@email.com"
    },
    "loanDate": "2023-03-10",
    "expectedReturnDate": "2023-03-17",
    "returnDate": null,
    "status": "ACTIVE"
  },
  {
    "id": "f6a7b8c9-d0e1-92f2-a3b4-c5d6e7f8a9b0",
    "book": {
      "id": "b2c3d4e5-f6a7-59b0-c8d9-e0f1a2b3c4d5",
      "title": "1984",
      "author": {
        "id": "8e9f0ad7-g447-53d1-c0a1-d4b2a3b5c6d7",
        "name": "George Orwell"
      }
    },
    "user": {
      "id": "d4e5f6a7-b8c9-70d1-e0f1-a2b3c4d5e6f7",
      "name": "Mary Johnson",
      "email": "mary.johnson@email.com"
    },
    "loanDate": "2023-02-25",
    "expectedReturnDate": "2023-03-04",
    "returnDate": "2023-03-02",
    "status": "RETURNED"
  }
]
```

### Get loan by ID

**Endpoint:** `GET /loans/{id}`

**Parameters:**
- `id` (path): Loan's UUID

**Success Response:**
- **Code:** 200 OK
- **Content:**
```json
{
  "id": "e5f6a7b8-c9d0-81e1-f2a3-b4c5d6e7f8a9",
  "book": {
    "id": "a1b2c3d4-e5f6-48a9-b7c8-d9e0f1a2b3c4",
    "title": "Dom Casmurro",
    "author": {
      "id": "5236c284-c7b8-45fc-a18a-e542b219faff",
      "name": "Machado de Assis"
    }
  },
  "user": {
    "id": "c3d4e5f6-a7b8-69c0-d9e0-f1a2b3c4d5e6",
    "name": "John Smith",
    "email": "john.smith@email.com"
  },
  "loanDate": "2023-03-10",
  "expectedReturnDate": "2023-03-17",
  "returnDate": null,
  "status": "ACTIVE"
}
```

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response

### Create loan

**Endpoint:** `POST /loans`

**Request Body:**
```json
{
  "userId": "c3d4e5f6-a7b8-69c0-d9e0-f1a2b3c4d5e6",
  "bookId": "a1b2c3d4-e5f6-48a9-b7c8-d9e0f1a2b3c4",
  "returnDate": "2023-03-24" // optional, if not provided, will be set to 7 days from current date
}
```

**Validations:**
- `userId`: Not null, must be an existing user's UUID
- `bookId`: Not null, must be an existing book's UUID
- `returnDate`: Optional, must be a future date or the current date

**Success Response:**
- **Code:** 201 Created
- **Headers:** `Location: /loans/{id}`
- **Content:** The created loan with its ID

**Error Response:**
- **Code:** 400 Bad Request
- **Content:** Details of the validation that failed or "The book is not available for loan"
- **Code:** 404 Not Found
- **Content:** Empty response (if the user or book doesn't exist)

### Register return

**Endpoint:** `PUT /loans/{id}/return`

**Parameters:**
- `id` (path): Loan's UUID

**Success Response:**
- **Code:** 200 OK
- **Content:** The updated loan with status RETURNED, return date filled, and book marked as available

**Error Response:**
- **Code:** 404 Not Found
- **Content:** Empty response
- **Code:** 400 Bad Request
- **Content:** "The book has already been returned!"

## API Usage Model

### Basic loan and return flow:

1. Register author: `POST /authors`
2. Register book: `POST /books` (referencing the author's ID)
3. Register user: `POST /users`
4. Create loan: `POST /loans` (referencing book and user IDs)
5. Return book: `PUT /loans/{id}/return`