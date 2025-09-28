CREATE DATABASE IF NOT EXISTS campus_events;
USE campus_events;

CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(150) UNIQUE,
  password VARCHAR(255),
  role ENUM('student','admin') DEFAULT 'student'
);

CREATE TABLE events (
  event_id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200),
  description TEXT,
  event_date DATE,
  event_time TIME,
  venue VARCHAR(150),
  capacity INT DEFAULT 100,
  created_by INT,
  FOREIGN KEY (created_by) REFERENCES users(user_id)
);

CREATE TABLE registrations (
  reg_id INT AUTO_INCREMENT PRIMARY KEY,
  event_id INT,
  user_id INT,
  reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE,
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
  UNIQUE KEY unique_reg (event_id, user_id)
);
