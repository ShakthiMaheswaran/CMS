CREATE TABLE student (
                          slno INT AUTO_INCREMENT PRIMARY KEY,
                          roll_no VARCHAR(20) UNIQUE NOT NULL,
                          name VARCHAR(100) NOT NULL,
                          year INT NOT NULL,
                          dept VARCHAR(50) NOT NULL
);

 -- Insert a Single Row (Specifying Columns)
INSERT INTO student (roll_no, name, year, dept)
VALUES ('R101', 'Rahul Sharma', 2026, 'Computer Science');

-- Insert Multiple Rows at Once
INSERT INTO student (roll_no, name, year, dept)
VALUES
    ('R102', 'Anjali Desai', 2026, 'Information Technology'),
    ('R103', 'Vikram Singh', 2025, 'Mechanical Engineering'),
    ('R104', 'Sneha Reddy', 2027, 'Electronics');


-- Get All Students (All Columns and Rows)
SELECT * FROM student;

--Get Specific Columns Only
SELECT name, dept FROM student;

--Filter Data with WHERE (e.g., a specific Department or Year)
SELECT * FROM student
WHERE dept = 'Computer Science';

SELECT roll_no, name, year
FROM student
WHERE year = 2026;

SELECT * FROM student
WHERE year = 2026 AND dept = 'Computer Science';


--Search Using LIKE (Pattern Matching)
SELECT * FROM student
WHERE name LIKE 'A%';

--Sort the Results with ORDER BY
SELECT * FROM student
ORDER BY name ASC;

--Update Student Data (UPDATE)
UPDATE student
SET dept = 'Artificial Intelligence'
WHERE roll_no = 'R101';

--Update multiple columns (e.g., year and department) at once:
UPDATE student
SET year = 2027, dept = 'Computer Science'
WHERE name = 'Rahul Sharma';

-- Delete Student Data (DELETE)
DELETE FROM student
WHERE roll_no = 'R104';

--Delete students matching a condition (e.g., from a specific year)
DELETE FROM student
WHERE year = 2025;

--Clear all records while keeping the table structure intact:
TRUNCATE TABLE student;

-----------------------------------------------------------------------------------------------------------------

-- Bulk Insertion Query -1

INSERT INTO student (roll_no, name, year, dept)
WITH RECURSIVE seq AS (
    -- Loop 100 times to generate 100 rows
    SELECT 1 AS id
    UNION ALL
    SELECT id + 1 FROM seq WHERE id < 100
),
               departments AS (
                   -- A pool of temporary departments and sample names to pick from randomly
                   SELECT 1 as d_id, 'Computer Science' as d_name, 'Rahul Sharma' as s_name UNION ALL
                   SELECT 2, 'Information Technology', 'Anjali Desai' UNION ALL
                   SELECT 3, 'Mechanical Engineering', 'Vikram Singh' UNION ALL
                   SELECT 4, 'Electronics', 'Sneha Reddy' UNION ALL
                   SELECT 5, 'Civil Engineering', 'Amit Patel'
               ),
               random_data AS (
                   SELECT
                       s.id,
                       -- Picks a random department from the list above
                       FLOOR(1 + RAND() * 5) as rand_dept_id,
                       -- Picks a random year between 1 and 4
                       FLOOR(1 + RAND() * 4) as rand_year
                   FROM seq s
               )
SELECT
    -- 1. Roll No: First 4 letters of dept (uppercase) + 4 digit number (padded with zeros)
    CONCAT(UPPER(LEFT(d.d_name, 4)), LPAD(r.id, 4, '0')) AS roll_no,
    -- 2. Name: Combines a baseline name with the sequence number to keep it distinct
    CONCAT(d.s_name, ' ', r.id) AS name,
    -- 3. Year
    r.rand_year AS year,
    -- 4. Dept
    d.d_name AS dept
FROM random_data r
    JOIN departments d ON r.rand_dept_id = d.d_id;


-----------------------------------------------------------------------------------------------------------------

-- Bulk Insertion Query 2

INSERT INTO student (roll_no, name, year, dept)
WITH RECURSIVE seq AS (
    SELECT 1 AS id
    UNION ALL
    SELECT id + 1 FROM seq WHERE id < 100
),
               first_names AS (
                   SELECT 1 AS fn_id, 'Arjun' AS fn UNION ALL SELECT 2, 'Aditya' UNION ALL SELECT 3, 'Rohan' UNION ALL SELECT 4, 'Aarav' UNION ALL SELECT 5, 'Sai' UNION ALL
                   SELECT 6, 'Priya' UNION ALL SELECT 7, 'Ananya' UNION ALL SELECT 8, 'Neha' UNION ALL SELECT 9, 'Kavya' UNION ALL SELECT 10, 'Diya' UNION ALL
                   SELECT 11, 'Vijay' UNION ALL SELECT 12, 'Kiran' UNION ALL SELECT 13, 'Sanjay' UNION ALL SELECT 14, 'Deepak' UNION ALL SELECT 15, 'Ravi' UNION ALL
                   SELECT 16, 'Ishaan' UNION ALL SELECT 17, 'Kabir' UNION ALL SELECT 18, 'Meera' UNION ALL SELECT 19, 'Riya' UNION ALL SELECT 20, 'Shreya'
               ),
               last_names AS (
                   SELECT 1 AS ln_id, 'Sharma' AS ln UNION ALL SELECT 2, 'Verma' UNION ALL SELECT 3, 'Kumar' UNION ALL SELECT 4, 'Singh' UNION ALL SELECT 5, 'Reddy' UNION ALL
                   SELECT 6, 'Patel' UNION ALL SELECT 7, 'Joshi' UNION ALL SELECT 8, 'Das' UNION ALL SELECT 9, 'Nair' UNION ALL SELECT 10, 'Pillai' UNION ALL
                   SELECT 11, 'Gupta' UNION ALL SELECT 12, 'Mishra' UNION ALL SELECT 13, 'Mehta' UNION ALL SELECT 14, 'Rao' UNION ALL SELECT 15, 'Hegde'
               ),
               depts AS (
                   SELECT 1 AS d_id, 'Computer Science' AS d_name UNION ALL
                   SELECT 2, 'Information Technology' UNION ALL
                   SELECT 3, 'Mechanical Engineering' UNION ALL
                   SELECT 4, 'Electronics' UNION ALL
                   SELECT 5, 'Civil Engineering'
               ),
               scrambled_data AS (
                   SELECT
                       s.id,
                       -- Math logic to pick a unique combination of first name and last name for every row
                       ((s.id * 7) % 20) + 1 AS fn_lookup,
    ((s.id * 13) % 15) + 1 AS ln_lookup,
               -- Randomly distribute departments (1 to 5) and years (1 to 4)
    (s.id % 5) + 1 AS d_lookup,
    (s.id % 4) + 1 AS year_val
FROM seq s
    )
SELECT
    -- Roll No logic: 4 letters of Dept + 4 digit ID (e.g., COMP0001, MECH0045)
    CONCAT(UPPER(LEFT(d.d_name, 4)), LPAD(sd.id, 4, '0')) AS roll_no,
    -- Unique Combination of First Name + Last Name
    CONCAT(f.fn, ' ', l.ln) AS name,
    sd.year_val AS year,
    d.d_name AS dept
FROM scrambled_data sd
    JOIN first_names f ON sd.fn_lookup = f.fn_id
    JOIN last_names l ON sd.ln_lookup = l.ln_id
    JOIN depts d ON sd.d_lookup = d.d_id;

-----------------------------------------------------------------------------------------------------------------

