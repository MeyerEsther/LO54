CREATE DATABASE IF NOT EXISTS LO54;

USE LO54;

CREATE TABLE IF NOT EXISTS location (
    id INT NOT NULL AUTO_INCREMENT,
    city VARCHAR(255) NOT NULL UNIQUE,
    latitude VARCHAR(255) NOT NULL,
    longitude  VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS course (
    code varchar(255) NOT NULL,
    title VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY(code)
);

CREATE TABLE IF NOT EXISTS course_session (
    id INT NOT NULL AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    max INT,
    course_code varchar(255) NOT NULL,
    location_id INTEGER NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (course_code) REFERENCES course(code),
    FOREIGN KEY (location_id) REFERENCES location(id)
);

CREATE TABLE IF NOT EXISTS client (
    id INT NOT NULL AUTO_INCREMENT,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    course_session_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (course_session_id) REFERENCES course_session(id)
);