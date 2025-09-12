package com.Practise.MongoDB;

public class PractiseInterview {
    /*
    * Enterprise grade system design along with a problem discussion
        Database Fundamentals, specifically around SQL (Indexes, Stored Procedures, Triggers, Schema Design Problem, Functions, Transactions etc.)
        Core JAVA Theory
        Advanced JAVA Theory (Spring, Hibernate, AOT etc.)
        Application Security fundamentals (JWT, CSRF, Method based security, RBAC etc.)
        Restful APIs and framework
        Multithreading
        Diagnostics, Debugging and Problem Solving
        Leadership Principles

    * * */




    // How would you design a schema for a movie booking system?
    /*
    * Design schema for a movie booking system.
    * Create tables for movies, theaters, users, bookings, and payments.
    Use foreign keys to establish relationships between tables.
    Include attributes like movie title, showtime, seat number, user details, booking status, payment details, etc.
    Consider implementing a booking algorithm to handle seat selection and availability.
    Ensure data integrity and normalization for efficient data retrieval and storage.
      */


    /*
    *
    * How would you scale the app (database wise) across India?
        Ans. To scale the app database over India, consider sharding, replication, and using cloud services.
        Implement sharding to distribute data across multiple servers based on geographic location or other criteria.
        Set up replication to ensure data consistency and availability in different regions.
        Utilize cloud services like AWS or Azure to easily scale resources based on demand.
        Optimize queries and indexes to improve database performance.
        Consider using a content delivery network (CDN) to cache and deliver static content efficiently.
    * */

        /*
        *What is the difference between sharding and partitioning?
        Ans. Sharding and partitioning are both techniques used in database management to improve performance and scalability by dividing data into smaller chunks.
        Sharding involves splitting a database into smaller, independent databases called shards, each responsible for a subset of the data.
        Partitioning involves dividing a database into smaller segments called partitions, each containing a subset of the data based on a defined criteria such as range or hash value.
        Sharding is typically used in distributed databases to distribute the workload and improve performance, while partitioning is often used in single-node databases to manage data more efficiently.
        Examples of sharding include MongoDB's sharded clusters, while examples of partitioning include MySQL's partitioning feature.
        * */


    /*
    *What is sharding vs partitioning
Ans. Sharding and partitioning are both techniques used in database management to improve performance and scalability by dividing data into smaller chunks.
Sharding involves splitting a database into smaller, independent databases called shards, each responsible for a subset of the data.
Partitioning involves dividing a database into smaller segments called partitions, each containing a subset of the data based on a defined criteria such as range or hash value.
Sharding is typically used in distributed databases to distribute the workload and improve performance, while partitioning is often used in single-node databases to manage data more efficiently.
Examples of sharding include MongoDB's sharded clusters, while examples of partitioning include MySQL's partitioning feature.
    * */

/*
* What are the 3 basic components of database, and do a RCA for why a DB is down.
Ans. The 3 basic components of a database are data, schema, and software. An RCA for a DB being down involves identifying the root cause of the issue.
Data: the actual information stored in the database, such as customer records or product details.
Schema: the structure that defines how the data is organized and related to each other, including tables, fields, and relationships.
Software: the database management system (DBMS) that allows users to interact with the data, such as MySQL, Oracle, or SQL Server.
RCA for a DB being down involves investigating factors like network issues, hardware failures, software bugs, or configuration errors.
For example, a DB could be down due to a network outage preventing communication with the server, or a hardware failure causing data corruption.
*
*  */

    /*
    * . Database indexing, partitioning, sharding.*/
/*Release planning, ci/cd setup, yaml script, community cloud, data management*/


    /*
    *    Brush up on core Java concepts like multithreading, collections,
    * *  and design patterns. They'll likely ask about your experience
    * *  with distributed systems, scalability, and performance optimization.
    * *  MongoDB-specific questions might cover topics like data modeling,
    * *  indexing strategies, and aggregation pipelines.

    * *   Don't forget to prepare for system design questions and coding challenges.
    * *  They might ask you to design a distributed database system or optimize
    * *  a query. Be ready to discuss your past projects and how you've solved
    * *  complex problems. If you're worried about tricky interview questions,
    * *  you might want to check out this copilot interview app. I'm on the team
    * *  that made it, and it's designed to help people navigate tough interview
    * * scenarios and boost their confidence.
    * * */



    /*Interview round 28th july*/
//    https://www.mongodb.com/resources/solutions/use-cases/application-modernization
    //https://www.mongodb.com/library/ai/discover-bendigo-adelaide-bank



/*
 *   The purpose of this round is to evaluate your technical proficiency on a more conceptual and fundamental level
 * * across a plethora of core CS topics. We will judge your problem solving skills and the approach
 * * you take to solve a problem. This round should focus on the following aspects:

    Enterprise grade system design along with a problem discussion
    Database Fundamentals, specifically around SQL (Indexes, Stored Procedures, Triggers, Schema Design Problem, Functions, Transactions etc.)
    Core JAVA Theory
    Advanced JAVA Theory (Spring, Hibernate, AOT etc.)
    Application Security fundamentals (JWT, CSRF, Method based security, RBAC etc.)
    Restful APIs and framework
    Multithreading
    Diagnostics, Debugging and Problem Solving
    Leadership Principles
*
* */

    /*🎯 1️⃣ Indexes

👉 What they are:
Indexes are special data structures that speed up queries by allowing the database to find rows quickly without scanning the whole table.

SQL
CREATE INDEX idx_user_email ON users(email);


This speeds up:
SELECT * FROM users WHERE email = 'test@example.com';


⚠️ Tradeoff:
	•	Speeds up reads
	•	Slows down writes (INSERT/UPDATE/DELETE) because index must be updated.
	•	Takes up storage.



🎯 2️⃣ Stored Procedures

👉 What they are:
A stored procedure is precompiled SQL logic stored in the DB, which can be executed with parameters.
They are used to encapsulate business logic, enforce rules closer to data, and sometimes improve performance.

📌 Example:
DELIMITER //

CREATE PROCEDURE AddUser(IN name VARCHAR(50), IN email VARCHAR(100))
BEGIN
  INSERT INTO users (name, email) VALUES (name, email);
END //

DELIMITER ;

CALL AddUser('Ravi', 'ravi@example.com');



🎯 3️⃣ Triggers

👉 What they are:
Triggers are automatic actions that run when an event occurs — like an INSERT, UPDATE, or DELETE.

Use case: Keep audit logs, auto-update other tables.

📌 Example:

CREATE TRIGGER log_user_insert
AFTER INSERT ON users
FOR EACH ROW
INSERT INTO audit_log (user_id, action, timestamp)
VALUES (NEW.id, 'INSERT', NOW());

🎯 4️⃣ Schema Design Problem

👉 What it means:
How you design tables, keys, relationships, constraints to meet functional & non-functional requirements.

Key tips:
	•	Normalization: Avoid redundant data → use 1NF, 2NF, 3NF.
	•	Primary Key: Unique ID for each row.
	•	Foreign Key: Link between tables.
	•	Indexes: Add wisely for performance.
	•	Check Constraints: Ensure valid data.

📌 Example: Movie Booking:
	•	movies → showtimes → bookings
	•	user_id FK in bookings → users
	•	Add index on showtime_id + seat_number to prevent double booking.


	🎯 5️⃣ Functions

👉 What they are:
Stored user-defined functions (UDFs) that return a value. Unlike stored procedures, functions must return a value and can be used in SELECT.


CREATE FUNCTION getFullName(firstName VARCHAR(50), lastName VARCHAR(50))
RETURNS VARCHAR(100)
RETURN CONCAT(firstName, ' ', lastName);

SELECT getFullName('Ravi', 'Sharma');

🎯 6️⃣ Transactions

👉 What they are:
A transaction is a group of SQL operations executed as a single unit — it either all succeeds or none does.
Ensures ACID: Atomicity, Consistency, Isolation, Durability.

📌 Example:

BEGIN;

UPDATE accounts SET balance = balance - 100 WHERE id = 1;
UPDATE accounts SET balance = balance + 100 WHERE id = 2;

COMMIT; -- If both succeed
-- or ROLLBACK; if any fails


Concept   Example in a System
Index              Fast seat lookup, find user by email
Stored Procedure   Complex booking rules inside DB
Trigger            Auto-insert audit trail when booking created
Function           Format seat labels, calculate totals
Transaction        Book seats + confirm payment atomically
Schema Design      Normalize seats, bookings, payments


⚙️ Bonus: When to be careful
	•	Too many indexes → slow writes.
	•	Triggers → can be hard to debug, hidden logic.
	•	Big stored procedures → can lock you into one DB vendor.
	•	Long transactions → risk of deadlocks.


✅ ✅ How to talk about this in an interview

📌 Sample line:

“I’d design the booking flow so that the seat check and booking insert happen inside a DB transaction to guarantee atomicity.
I’d add indexes on showtime_id and seat_number for fast seat availability checks.
I might use a trigger to log booking changes for audit, or a stored procedure to handle seat allocation logic in the DB to reduce round trips.”

⸻

*/

}
