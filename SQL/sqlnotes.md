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
- select disctinct title from films order by release_year  - Why it doesn't doesn't work 1. release_year is not there in select .  
