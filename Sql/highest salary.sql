Question: Finding the highest salary in different department

Employee  table 

+----+--------+--------+--------------+ 
| Id | Name   | Salary | DepartmentId | 
+----+--------+--------+--------------+ 
| 1  | Joe    | 70000  | 1            | 
| 2  | Henry  | 80000  | 2            | 
| 3  | Sam    | 60000  | 2            | 
| 4  | Max    | 90000  | 1            | 
+----+--------+--------+--------------+ 

Department  table 

+----+----------+ 
| Id | Name     | 
+----+----------+ 
| 1  | IT       | 
| 2  | Sales    | 
+----+----------+ 


Expected answer 
+------------+----------+--------+ 
| Department | Employee | Salary | 
+------------+----------+--------+ 
| IT         | Max      | 90000  | 
| Sales      | Henry    | 80000  | 
+------------+----------+--------+ 


Solution: 

First step: select max salary in the Employee table
-- start part A
select Name, Salary, DepartmentId 
from TrainDB.dbo.Employee as B1 
where Salary = ( 
select max(Salary) 
from TrainDB.dbo.Employee as A1 
where A1.DepartmentId = B1.DepartmentId) 
-- end part A
Second step: use the another table to join the table, and then you can get the result.


SELECT A.Name as Department, B.Name as Employee, B.Salary 
FROM TrainDB.dbo.Department as A 
left join ( 
-- start part A
select Name, Salary, DepartmentId 
from TrainDB.dbo.Employee as B1 
where Salary = ( 
select max(Salary) 
from TrainDB.dbo.Employee as A1 
where A1.DepartmentId = B1.DepartmentId) 
-- end part A
) as B ON B.DepartmentId = A.Id
