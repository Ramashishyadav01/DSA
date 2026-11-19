-- Write your PostgreSQL query statement below
SELECT email
FROM person email
GROUP BY email
HAVING COUNT(email) > 1;
