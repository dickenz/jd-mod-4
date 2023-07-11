SELECT
    p.ID,
    (DATEDIFF(MONTH, p.START_DATE, p.FINISH_DATE) + 1) *
        (SELECT SUM(w.SALARY)
         FROM worker w
         JOIN project_worker pw ON pw.WORKER_ID = w.ID
         WHERE pw.PROJECT_ID = p.ID) AS PRICE
FROM project p
ORDER BY PRICE DESC;