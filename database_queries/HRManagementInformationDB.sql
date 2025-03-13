CREATE DATABASE HRManagementInformationDB;
USE HRManagementInformationDB;

-- ROLES Tablosu
CREATE TABLE Roles (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_title VARCHAR(255) NOT NULL,
    role_description TEXT
);

-- DEPARTMENTS Tablosu
CREATE TABLE Departments (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(255) NOT NULL
);

-- DOCUMENT_TYPE Tablosu
CREATE TABLE DocumentTypes (
    document_type_id INT PRIMARY KEY AUTO_INCREMENT,
    type_name VARCHAR(255) NOT NULL,
    description TEXT
);

-- LEAVE_TYPES Tablosu
CREATE TABLE LeaveTypes (
    leave_type_id INT PRIMARY KEY AUTO_INCREMENT,
    leave_type_name VARCHAR(255) NOT NULL,
    description TEXT
);

-- INSURANCE_TYPES Tablosu
CREATE TABLE InsuranceTypes (
    insurance_type_id INT PRIMARY KEY AUTO_INCREMENT,
    insurance_type_name VARCHAR(255) NOT NULL,
    description TEXT
);

-- USERS Tablosu
CREATE TABLE Users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birth_date DATE,
    email VARCHAR(255),
    phone VARCHAR(20),
    hire_date DATE,
    role_id INT,
    department_id INT,
    password VARCHAR(255),
    FOREIGN KEY (role_id) REFERENCES Roles(role_id),
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

-- SALARIES Tablosu
CREATE TABLE Salaries (
    salary_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    salary_amount DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- PAYROLL_RECORDS Tablosu
CREATE TABLE PayrollRecords (
    payroll_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    payroll_date DATE,
    base_salary DECIMAL(10,2),
    bonuses DECIMAL(10,2),
    deductions DECIMAL(10,2),
    net_salary DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- RECRUITMENT Tablosu
CREATE TABLE Recruitments (
    recruitment_id INT PRIMARY KEY AUTO_INCREMENT,
    candidate_name VARCHAR(255),
    application_date DATE,
    position_id INT,
    status VARCHAR(50),
    notes TEXT
);

-- INTERVIEWS Tablosu
CREATE TABLE Interviews (
    interview_id INT PRIMARY KEY AUTO_INCREMENT,
    recruitment_id INT,
    interview_date DATE,
    feedback TEXT,
    FOREIGN KEY (recruitment_id) REFERENCES Recruitments(recruitment_id)
);

-- JOB_OFFERS Tablosu
CREATE TABLE JobOffers (
    offer_id INT PRIMARY KEY AUTO_INCREMENT,
    recruitment_id INT,
    offer_date DATE,
    offer_status VARCHAR(50),
    offered_salary DECIMAL(10,2),
    feedback TEXT,
    FOREIGN KEY (recruitment_id) REFERENCES Recruitments(recruitment_id)
);

-- EMPLOYEE_ATTENDANCE Tablosu
CREATE TABLE EmployeeAttandance (
    attendance_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    attendance_date DATE,
    check_in_time TIME,
    check_out_time TIME,
    overtime_hours DECIMAL(5,2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- MONTHLY_GOALS Tablosu
CREATE TABLE MonthlyGoals (
    goal_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    year INT,
    month INT,
    target_description VARCHAR(255),
    goal_value DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- EMPLOYEE_DOCUMENTS Tablosu
CREATE TABLE EmployeeDocuments (
    document_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    document_type_id INT,
    file_path VARCHAR(255),
    upload_date DATE,
    valid_until DATE,
    status VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (document_type_id) REFERENCES DocumentTypes(document_type_id)
);

-- LEAVE_REQUEST Tablosu
CREATE TABLE LeaveRequests (
    leave_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    leave_type_id INT,
    start_date DATE,
    end_date DATE,
    total_days DECIMAL(5,2),
    note TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (leave_type_id) REFERENCES LeaveTypes(leave_type_id)
);

-- PROMOTIONS Tablosu
CREATE TABLE Promotions (
    promotion_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    old_position_id INT,
    new_position_id INT,
    promotion_date DATE,
    salary_increase_rate DECIMAL(5,2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (old_position_id) REFERENCES Roles(role_id),
    FOREIGN KEY (new_position_id) REFERENCES Roles(role_id)
);

-- INSURANCE_RECORD Tablosu
CREATE TABLE InsuranceRecords (
    insurance_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    insurance_type_id INT,
    start_date DATE,
    end_date DATE,
    insurance_number VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (insurance_type_id) REFERENCES InsuranceTypes(insurance_type_id)
);

-- EXIT_RECORDS Tablosu
CREATE TABLE ExitRecords (
    exit_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    exit_date DATE,
    reason TEXT,
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- HR_MEETING_NOTES Tablosu
CREATE TABLE HRMeetingNotes (
    note_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    meeting_date DATE,
    category VARCHAR(50),
    notes TEXT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);
