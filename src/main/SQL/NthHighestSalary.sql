CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
     SELECT MIN(Salary) from (
        SELECT Salary from Employee emp ORDER BY emp.Salary DESC LIMIT N
        ) AS emp


  );
END
