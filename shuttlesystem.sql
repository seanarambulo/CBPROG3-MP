-- Create Schema
CREATE SCHEMA IF NOT EXISTS shuttlesystem;

-- Use the created schema
USE shuttlesystem;

-- Drop existing tables if they exist
DROP TABLE IF EXISTS ShuttleBookingPreset;
DROP TABLE IF EXISTS IrregShuttleBooking;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS LineTime;
DROP TABLE IF EXISTS ArrowsExpressLine;
DROP TABLE IF EXISTS TrimesterSchedule;
DROP TABLE IF EXISTS ClassDays;
DROP TABLE IF EXISTS Student;
DROP TABLE IF EXISTS Days;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Trimester;
DROP TABLE IF EXISTS Time;
DROP TABLE IF EXISTS Designation;


-- Designation Table
CREATE TABLE Designation (
    DesignationID INT AUTO_INCREMENT PRIMARY KEY,
    DesignationType VARCHAR(45) NOT NULL
);

-- Days Table
CREATE TABLE Days (
    DaysID INT AUTO_INCREMENT PRIMARY KEY,
    DayName VARCHAR(45) NOT NULL
);

-- Time Table
CREATE TABLE Time (
    TimeID INT AUTO_INCREMENT PRIMARY KEY,
    Time TIME NOT NULL
);

-- Trimester Table
CREATE TABLE Trimester (
    TrimesterID INT AUTO_INCREMENT PRIMARY KEY,
    YearNum INT NOT NULL,
    TermNum INT NOT NULL
);

-- User Table
CREATE TABLE User (
    UserID BIGINT NOT NULL PRIMARY KEY, -- 8-digit User ID
    UserName VARCHAR(45) NOT NULL,
    Password VARCHAR(45) NOT NULL,
    Email VARCHAR(45) NOT NULL,
    DesignationID INT NOT NULL,
    FOREIGN KEY (DesignationID) REFERENCES Designation(DesignationID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Student Table
CREATE TABLE Student (
    StudentID BIGINT NOT NULL PRIMARY KEY, 
    TrimesterID INT NOT NULL,
    EAF VARCHAR(255) NOT NULL,
    isVerified BOOLEAN NOT NULL,
    enrolledAs VARCHAR(90) NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES User(UserID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	FOREIGN KEY (TrimesterID) REFERENCES Trimester(TrimesterID)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);


-- ClassDays Table
CREATE TABLE ClassDays (
    DaysID INT NOT NULL, 
    StudentID BIGINT NOT NULL,
    PRIMARY KEY (DaysID, StudentID), -- Composite primary key
    FOREIGN KEY (DaysID) REFERENCES Days(DaysID) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE,
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
);


-- TrimesterSchedule Table
CREATE TABLE TrimesterSchedule (
    TrimesterScheduleID INT AUTO_INCREMENT PRIMARY KEY,
    TrimesterID INT NOT NULL,
    TimeID INT NOT NULL,
    FOREIGN KEY (TimeID) REFERENCES Time(TimeID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (TrimesterID) REFERENCES Trimester(TrimesterID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE ArrowsExpressLine (
    LineID INT AUTO_INCREMENT PRIMARY KEY,
    LineName VARCHAR(45) NOT NULL
);

CREATE TABLE LineTime (
    LineID INT NOT NULL,
    TimeID INT NOT NULL,
     PRIMARY KEY (LineID, TimeID), -- Composite primary key
    FOREIGN KEY (LineID) REFERENCES ArrowsExpressLine(LineID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (TimeID) REFERENCES Time(TimeID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- ArrowsExpressLine Table


-- Booking Table
CREATE TABLE Booking (
    ShuttleBookingID INT AUTO_INCREMENT PRIMARY KEY,
    Attendance BOOLEAN NOT NULL,
    Origin VARCHAR(45) NOT NULL,
    Destination VARCHAR(45) NOT NULL,
    Date DATE NOT NULL,
    LineID INT NOT NULL,
    UserID BIGINT NOT NULL,
    TimeID INT NOT NULL,
    FOREIGN KEY (TimeID) REFERENCES Time(TimeID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (LineID) REFERENCES ArrowsExpressLine(LineID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- ShuttleBookingPreset Table
CREATE TABLE ShuttleBookingPreset (
    PresetID INT AUTO_INCREMENT PRIMARY KEY,
    ShuttleBookingID INT NOT NULL,
    FOREIGN KEY (ShuttleBookingID) REFERENCES Booking(ShuttleBookingID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- IrregShuttleBooking Table
CREATE TABLE IrregShuttleBooking (
    IrregShuttleBookingID INT NOT NULL PRIMARY KEY, 
    Reason VARCHAR(255) NOT NULL,
    isApproved BOOLEAN NOT NULL,
    FOREIGN KEY (IrregShuttleBookingID) REFERENCES Booking(ShuttleBookingID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);


-- Populate Designation Table
INSERT INTO Designation (DesignationType) 
VALUES 
    ('Admin'), 
    ('Dispatcher'), 
    ('Employee'), 
    ('Student');

-- Populate ClassDays Table
INSERT INTO Days (DayName) 
VALUES 
    ('Monday'), 
    ('Tuesday'), 
    ('Wednesday'), 
    ('Thursday'),
    ('Friday'), 
    ('Saturday');

-- Populate Time Table
INSERT INTO Time (Time) 
VALUES 
    ('08:00:00'), 
    ('10:00:00'), 
    ('13:00:00'), 
    ('15:00:00');

-- Populate Trimester Table
INSERT INTO Trimester (YearNum, TermNum) 
VALUES 
    (2024, 1), 
    (2024, 2), 
    (2024, 3), 
    (2025, 1);

-- Populate User Table
INSERT INTO User (UserID, UserName, Password, Email, DesignationID) 
VALUES 
    (10000001, 'Admin1', 'password1', 'admin1@example.com', 1),
    (20000002, 'Dispatcher1', 'password2', 'dispatcher1@example.com', 2),
    (30000003, 'Employee1', 'password3', 'employee1@example.com', 3),
    (12344818, 'Student1', 'password4', 'student1@example.com', 4),
    (12340006, 'Student2', 'password3', 'student3@example.com', 4),
    (12345678, 'Student2', 'password2', 'student2@example.com', 4);

-- Populate Student Table
INSERT INTO Student (StudentID, TrimesterID, EAF, isVerified, enrolledAs) 
VALUES 
    (12344818, 1, 'http://example.com/eaf1', TRUE,'College - Laguna Enrolled without class/es in Manila'),
    (12340006, 1, 'http://example.com/eaf3', TRUE,'College - Laguna Enrolled with class/es in Manila'),
    (12345678, 1, 'http://example.com/eaf2', TRUE,'College - Laguna Enrolled without class/es in Manila');

INSERT INTO classdays (DaysID,StudentID) 
VALUES 
    (1,12344818), 
    (1,12340006),
    (1,12345678),
    (2,12344818), 
    (2,12340006), 
    (3,12345678);

-- Populate TrimesterSchedule Table
INSERT INTO TrimesterSchedule (TrimesterID, TimeID) 
VALUES 
    (1, 1), 
    (2, 2), 
    (3, 3), 
    (4, 4);
    
-- Populate ArrowsExpressLine Table
INSERT INTO ArrowsExpressLine (LineName) 
VALUES 
    ('MANILA<-->LAGUNA'), 
    ('PASEO<-->LAGUNA'), 
    ('CARMONA<-->LAGUNA'), 
    ('PAVILION<-->LAGUNA'), 
    ('WALTER<-->LAGUNA'); 

INSERT INTO LineTime (LineID,TimeID)
VALUES
	(1,1),
    (1,2),
    (2,1),
    (2,2),
    (2,3)
;

-- Populate Booking Table
INSERT INTO Booking (Attendance, Origin, Destination, Date, LineID, UserID,TimeID)
VALUES
    (TRUE, 'MANILA', 'LAGUNA', '2024-11-25', 1, 12344818,1),
    (FALSE, 'LAGUNA', 'PASEO', '2024-11-25', 2, 12344818,2),
    (TRUE, 'MANILA', 'LAGUNA', '2024-11-25', 1, 12340006,1),
    (FALSE, 'LAGUNA', 'PASEO', '2024-11-25', 2, 12340006,2),
    (TRUE, 'MANILA', 'LAGUNA', '2024-11-26', 1, 12345678,1),
    (FALSE, 'PASEO', 'LAGUNA', '2024-11-26', 2, 12345678,2);

-- Populate ShuttleBookingPreset Table
INSERT INTO ShuttleBookingPreset (ShuttleBookingID) 
VALUES 
    (1), 
    (2);

-- Populate IrregShuttleBooking Table
INSERT INTO IrregShuttleBooking (IrregShuttleBookingID, Reason, isApproved) 
VALUES 
    (1, 'Medical Emergency', TRUE),
    (2, 'Traffic Jam', FALSE);
