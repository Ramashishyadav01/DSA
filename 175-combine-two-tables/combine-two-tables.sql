-- Write your PostgreSQL query statement below
SELECT 
p.firstName,
p.lastName,
a.city,
a.state
FROM person p
LEFT JOIN address a
ON p.personID = a.personID;