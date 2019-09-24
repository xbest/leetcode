/** SQL Schema **/
Create table If Not Exists Employee (Id int, Salary int);
Truncate table Employee;
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');

/*************** Problem Description ***************
Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
 *************** Problem Description ***************/

/*************** Problem Solution ***************/
select max(Salary) as SecondHighestSalary from Employee where Salary < (select max(Salary)from Employee);
select (select distinct Salary from Employee order by Salary desc limit 1 offset 1) as SecondHighestSalary;
/*************** Problem Solution ***************/