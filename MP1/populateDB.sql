-- Insert into Designation
INSERT INTO Designation (DesignationID, DesignationType)
VALUES
    (1, 'Admin'),
    (2, 'Student'),
    (3, 'Staff');

-- Insert into ClassDays
INSERT INTO ClassDays (ClassDaysID, DayName)
VALUES
    (1, 'Monday'),
    (2, 'Tuesday'),
    (3, 'Wednesday'),
    (4, 'Thursday');

-- Insert into Time
INSERT INTO Time (TimeID, Time)
VALUES
    (1, '08:00:00'),
    (2, '10:00:00'),
    (3, '12:00:00'),
    (4, '14:00:00');

-- Insert into ArrowsExpressLine
INSERT INTO ArrowsExpressLine (LineID, LineName, TimeID)
VALUES
    (1, 'Red Line', 1),
    (2, 'Blue Line', 2),
    (3, 'Green Line', 3),
    (4, 'Yellow Line', 4);

-- Insert into User
INSERT INTO User (UserID, UserName, Password, Email, DesignationID)
VALUES
    (1001, 'Admin1', 'adminpass', 'admin1@example.com', 1),
    (2001, 'JohnDoe', 'password123', 'johndoe@example.com', 2),
    (2002, 'JaneSmith', 'password456', 'janesmith@example.com', 2),
    (3001, 'Staff1', 'staffpass', 'staff1@example.com', 3);

-- Insert into Student
INSERT INTO Student (StudentID, Trimester, EAF, isVerified, ClassDaysID)
VALUES
    (2001, 1, 'http://example.com/eaf1', TRUE, 1),
    (2002, 2, 'http://example.com/eaf2', FALSE, 2);

-- Insert into Trimester
INSERT INTO Trimester (TrimesterID, YearNum, TermNum)
VALUES
    (1, 2024, 1),
    (2, 2024, 2);

-- Insert into TrimesterSchedule
INSERT INTO TrimesterSchedule (TrimesterScheduleID, TrimesterID, TimeID)
VALUES
    (1, 1, 1),
    (2, 2, 2);

-- Insert into Booking
INSERT INTO Booking (ShuttleBookingID, Attendance, Origin, Destination, Date, LineID, UserID)
VALUES
    (4001, TRUE, 'Location A', 'Location B', '2024-11-24', 1, 2001),
    (4002, FALSE, 'Location C', 'Location D', '2024-11-25', 2, 2002),
    (4003, TRUE, 'Location E', 'Location F', '2024-11-26', 3, 3001),
    (4004, TRUE, 'Location G', 'Location H', '2024-11-27', 4, 2001);


-- Insert into ShuttleBookingPreset
INSERT INTO ShuttleBookingPreset (PresetID, ShuttleBookingID)
VALUES
    (1, 4001),
    (2, 4002),
    (3, 4003);

-- Insert into IrregShuttleBooking
INSERT INTO IrregShuttleBooking (IrregShuttleBookingID, Reason, isApproved)
VALUES
    (4001, 'Missed regular schedule', TRUE),
    (4004, 'Emergency booking', FALSE);
