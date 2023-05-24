SELECT MONTH(START_DATE) as MONTH, h.CAR_ID, COUNT(h.CAR_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h join
(SELECT CAR_ID, COUNT(CAR_ID) AS RESULT
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
WHERE MONTH(START_DATE) BETWEEN 8 and 10
GROUP BY CAR_ID
HAVING RESULT > 4)
AS t on h.CAR_ID = t.CAR_ID
WHERE MONTH(START_DATE) BETWEEN 8 and 10
GROUP BY MONTH(START_DATE), h.CAR_ID 
HAVING RECORDS > 0
ORDER BY MONTH, CAR_ID DESC