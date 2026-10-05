CREATE DATABASE IF NOT EXISTS event_decorator_db;
USE event_decorator_db;

CREATE USER IF NOT EXISTS 'eventuser'@'localhost' IDENTIFIED BY 'event123';
GRANT ALL PRIVILEGES ON event_decorator_db.* TO 'eventuser'@'localhost';
FLUSH PRIVILEGES;
