-- Designation Table
CREATE TABLE Designation (
    DesignationID INT NOT NULL PRIMARY KEY,
    DesignationType VARCHAR(45) NOT NULL
);

-- ClassDays Table
CREATE TABLE ClassDays (
    ClassDaysID INT NOT NULL PRIMARY KEY,
    DayName VARCHAR(45) NOT NULL
);

-- Time Table
CREATE TABLE Time (
    TimeID INT NOT NULL PRIMARY KEY,
    Time TIME NOT NULL
);

-- Trimester Table
CREATE TABLE Trimester (
    TrimesterID INT NOT NULL PRIMARY KEY,
    YearNum INT NOT NULL,
    TermNum INT NOT NULL
);

-- User Table
CREATE TABLE User (
    UserID INT NOT NULL PRIMARY KEY,
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
    StudentID INT NOT NULL,
    Trimester INT NOT NULL,
    EAF VARCHAR(255) NOT NULL,
    isVerified BOOLEAN NOT NULL,
    ClassDaysID INT NOT NULL,
    FOREIGN KEY (ClassDaysID) REFERENCES ClassDays(ClassDaysID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (StudentID) REFERENCES User(UserID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    PRIMARY KEY (StudentID)
);

-- TrimesterSchedule Table
CREATE TABLE TrimesterSchedule (
    TrimesterScheduleID INT NOT NULL PRIMARY KEY,
    TrimesterID INT NOT NULL,
    TimeID INT NOT NULL,
    FOREIGN KEY (TimeID) REFERENCES Time(TimeID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (TrimesterID) REFERENCES Trimester(TrimesterID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- ArrowsExpressLine Table
CREATE TABLE ArrowsExpressLine (
    LineID INT NOT NULL PRIMARY KEY,
    LineName VARCHAR(45) NOT NULL,
    TimeID INT NOT NULL,
    FOREIGN KEY (TimeID) REFERENCES Time(TimeID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Booking Table
CREATE TABLE Booking (
    ShuttleBookingID INT NOT NULL PRIMARY KEY,
    Attendance BOOLEAN NOT NULL,
    Origin VARCHAR(45) NOT NULL,
    Destination VARCHAR(45) NOT NULL,
    Date DATE NOT NULL,
    LineID INT NOT NULL,
    UserID INT NOT NULL,
    FOREIGN KEY (LineID) REFERENCES ArrowsExpressLine(LineID)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- ShuttleBookingPreset Table
CREATE TABLE ShuttleBookingPreset (
    PresetID INT NOT NULL PRIMARY KEY,
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
