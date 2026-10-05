# Local Event Decoration & Floral Aggregator

Hackathon-ready full-stack application based on the supplied problem statement.

## Stack
Java 17, Spring Boot, REST API, Spring Data JPA/Hibernate, MySQL, React, Vite, Axios.

## Flow
React form -> Spring Boot Controller -> Service -> JPA Repository -> MySQL -> JSON -> React cards

## Features
- Search decorators by event type, location, service and budget
- Matching decorator cards with price, portfolio, availability and contact
- Booking form with validation
- UPI / Card / Cash payment-method selection
- MySQL persistence
- REST APIs
- Loading, success and error states
- Responsive UI
- Sample decorator data is inserted automatically

## MySQL
Run:

```sql
CREATE DATABASE event_decorator_db;
CREATE USER 'eventuser'@'localhost' IDENTIFIED BY 'event123';
GRANT ALL PRIVILEGES ON event_decorator_db.* TO 'eventuser'@'localhost';
FLUSH PRIVILEGES;
```

If you already use another MySQL username/password, edit
`backend/src/main/resources/application.properties`.

## Backend
Open terminal in `backend`:

```bash
mvn clean spring-boot:run
```

Backend URL: http://localhost:8080

## Frontend
Open another terminal in `frontend`:

```bash
npm install
npm run dev
```

Open the Vite URL, normally http://localhost:5173

## APIs
- GET `/api/health`
- GET `/api/decorators`
- GET `/api/decorators/search?eventType=Wedding&location=Nellore&budget=50000&service=Floral`
- POST `/api/bookings`
- GET `/api/bookings`

## GitHub
```bash
git init
git add .
git commit -m "Initial hackathon application"
git branch -M main
git remote add origin YOUR_GITHUB_REPOSITORY_URL
git push -u origin main
```

Payment method is recorded for the demo; no real money is charged.
