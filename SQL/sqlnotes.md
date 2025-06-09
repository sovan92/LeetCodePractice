# Keys
- Candidate keys - Minimal number of columns uniquely defining the column. A superkey is not always a candidate key. 
- Superkeys- larger set , a candiate key is always a super key .
- Primary Key - A single column candidate key (selected) that uniquely identifies the row.
  - Most of the database order the data in B Trees by the order of PK .
  - Output the data in order of Primary key.
  - MySQL does that.
  - UNIQUE
  - NOT NULL
  - AUTO INCR
- Composite key - mix (candiate key + some column)
- Snowflake algorithm Twitter - Generate Unique ID
- Foreign key - Unique key in one table provides a relationship in other table.  Foreign key need not be the primary key on Another table.
  - NO_ACTION - Doesn't allow to delete the column in the foreign table.
  - CASCADE - if the column in the foreign table is deleted the table row in specific table is deleted.
  - SET NULL - sets null to column.

 # Crud1

 - Create , Read, Update, Delete.
 - Sakila Database - Movie DB . Actor https://dev.mysql.com/doc/sakila/en/ (Schema + Datafile)
 - INSERT INTO TABLE (COLUMNS)
 - VALUES (A1, A2, A3, A4)
 - SELECT DISTINCT all columns in distinct .
 - You can't do SELECT COLM1, DISTINCT COLM2 (Doesn't make sense as well) -
 - First where clause, then distrinct keyword comes.
 - IN () Similar to OR
 - NOT IN
 - AND OR

# Crud2

- Order by-  uses , Quick Sort, Merge Sort heap sort.
- Between operator between is inclusive.
- like operator match the string  - word contains academy %academy% , word should have academy starting from 3rd character. `__ academy`. 
- SQL uses Modulo or KPModlo pattern match .
- all string within like is case insensitive.
- Revise Robincarp and KMP and Z algorithm. 
- is null or is not null , it can't be = null , when checking null.  select * from movie where release_year <> 2006 . THis doesn't contain null data.
- OrderBy - Sort by a particular column.  This is by default asc , if desc , mention desc after column.
- Behind the scene SQL orderby sorts by Quicksort, MergeSort, Heapsort .
- If 2 elements of the column in order by are same , it tries to sort by primary key .
- select disctinct title from films order by release_year  - Why it doesn't doesn't work 1. release_year is not there in select .   There can be a conflict .  so it should be select title, release_year from films order by release_year .
- select * from movies limit(10) , bring 10 first records .
- select * from movies order by release_year limit(10)  , first order by then limit .
- offset - select * from movies limit(10) offset(10) - remove the first 10 and then provide the 10 rows .
- select disctinct title from films order by release_year  - Why it doesn't doesn't work 1. release_year is not there in select .
- Update Movie set colum = 'Alpha' where colum = 'beta' . - Don't miss where , most sql vendors won't allow to do it.
- truncate table_name - No table data . So you you delete the table and recreate it.
- drop table tablename - No logs nothing . All table done.
- drop database databasename - all database gone.

# Joins 2 

| S_id     | Name  |B_id   |            
| -------- | ----- |-------|
| 1        | A1    |B1     |
| 4        | A4    |B1     |
| 5        | A5    |B2     |
| 2        | A2    |B2     |
| 3        | A3    |B3     |
| 6        | A6    |Null   |


| B_Id     | BName |  
| -------- | ----- |
| B1       | BName1|
| B2       | BName2|
| B3       | BName3|

### Inner Join
```sql
select S_id, Name, B_id, BName
from Student join Batch
on Student.B_id = Batch.B_id
```
### What is returned 

| S_id     | Name  |B_id   |BName   |          
| -------- | ----- |-------|--------|
| 1        | A1    |B1     |BName1  |
| 4        | A4    |B1     |BName2  |
| 5        | A5    |B2     |BName2  |
| 2        | A2    |B2     |BName2  |
| 3        | A3    |B3     |BName3  |
* Note : Null is not returned.  Row is matched if condition is matched.
### Left Join
```sql
select S_id, Name, B_id, BName
from Student left join Batch
on Student.B_id = Batch.B_id
```
* Note : Left join means rows in the inner table + rows in the left table.

* Note: FULL OUter join - My SQL doesn't support full outer join .
* Note: right join means rows in the inner table + rows in the right table.
* Note: Full outer join -  
* Note: Cross Join doesn't have a condition  , you can provide it .  Every row on the left have row on the right .




### Using vs ON 
Note:  If same column name , you can use USING, but it's not a good way
```sql
select S_id, Name, B_id, BName
from Student left join Batch
USING (B_id)
```
### Natural JOin 
It doesn't take ON or USING. It will join on same name columns present on both tables automatically. 
```sql
select S_id, Name, B_id, BName
from Student NATURAL JOIN Batch
```
Be very careful while using this. 

### Implicit join 
 It is same as cross join .  
```sql
select S_id, Name, B_id, BName
from Student, Batch
```
### The bane of where Vs On 
For ON , we add the data to the resultset of the join if the condition match , where as in WHERE , we complete the cross join, the result set is generated, post that we match the condition in the where 

# Aggregate function 

Count
Max
Min 
Avg
Sum 

* Note:  Aggregate function doesn't count not null values .
```sql
select count(*) from table. 
```
Count number of rows. 


```sql
select film_id, release_year
from films
group by film_id
```
Works - Why ? because every film id has a uniqueRelease year.  
The opposite is not true like

```sql
select film_id, release_year
from films
group by release_year
```
this doesn't work as each group of release_year has multiple film_ids which is ambigious . 
So it's ambiguity that's avoids column in select that is not agregated or not present in group by not some sql compiler logic. 

## Where is completely different from having  ?

```sql
select rental_duration, count(film_id)
from films
where rental_price > 4.99
group by rental_duration
having count(film_id) > 50
```
So where is applied on individual rows. So first we use the where clause. Then group by and then the condition on the group is applied. 

## Order of execution of sql 

```mermaid
flowchart LR;
    FROM-->JOINS;
    JOINS-->WHERE;
    WHERE-->GROUP[GROUP BY];
    GROUP[GROUP BY]-->HAVING;
    HAVING-->ORDER[ORDER BY];
    ORDER[ORDER BY]-->SELECT;
```

### One more caveat order by and having columns
Order by can contain alias , having cannot . 

* Example orderby containing alias
```sql
select department_id, avg(salary) as avg_employee_salary
from employees
group by department_id
order by avg_employee_salary desc

```
* Example of having cannot containing alias

```sql
select rental_duration, count(film_id)
from films
where rental_price > 4.99
group by rental_duration
having count(film_id) > 50
```
### Other row based functions to remember 
- round(column_name, P) -> Round to p places of decimal. 
- truncate(column_name, P)-> truncate to P paces of the decimal . 
- ifnull(column_name, 0) -> if null then convert to 0. 


## Subqueries and Views 
Sometimes you can't compare whether joins or SubQueries will have a better performance. 
- Subquery can be used for IN , FROM , > ALL , > ANY , WHERE 
- The query optimizer might convert the subquery into a Join . 
- A subquery can in used in the Where clause where the number of values returned is 1.
- A from based subquery ie - A subquery that follows from , then we have to use a Alias

### Corelated Subqueries 
- External loops data can be accepted in inner queries
- Just like scoping in loops. 
```sql
select *
from Students S
where psp > (select avg(psp), bid from Students where b_id = S.b_id group by b_id)

```
Note:  Outer batch id is passed to the subquery. 

### Exists 

WHERE EXIST()
- IF subquery return any data then it returns true or it returns false.

- Example
How to check if the student is a TA or not

#### Way 1 

```sql
select * from
Student
where ID in (select st_id from TA where st_id is not null);
```

#### Way 2
```sql
select * from
Student S
WHERE ID exists (select stid from TA where stid = S.id)
```
The second way may be better . 

### Views

```sql
create view big_query as(


);
select * from big_query
```
- Index views stored in database.
- Partition views are stored in multiple partitions.
- 
