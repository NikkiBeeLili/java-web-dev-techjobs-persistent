## Part 1: Test it with SQL
SELECT *
FROM techjobs.jobs;

## Part 2: Test it with SQL
SELECT name
FROM techjobs.jobs
WHERE location=St. Louis is TRUE;

## Part 3: Test it with SQL
DROP TABLE techjobs.jobs;

## Part 4: Test it with SQL
SELECT name, description
FROM techjobs.skill
WHERE job_id IS NOT NULL
ORDER BY name ASC
