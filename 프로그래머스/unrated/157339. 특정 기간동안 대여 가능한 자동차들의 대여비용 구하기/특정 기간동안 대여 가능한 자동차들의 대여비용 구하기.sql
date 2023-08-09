SELECT f.CAR_ID, f.CAR_TYPE, ROUND(DAILY_FEE * 30 * (1 - DISCOUNT_RATE / 100), 0) as FEE
FROM (SELECT p.CAR_ID, c.CAR_TYPE, DAILY_FEE
FROM 
(SELECT CAR_ID,  IF (CAR_ID in (SELECT h.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h JOIN CAR_RENTAL_COMPANY_CAR c ON h.CAR_ID = c.CAR_ID
WHERE END_DATE >= "2022-11-01" and START_DATE <= "2022-12-01"
ORDER BY h.CAR_ID), 0, 1) as AVAILABLE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY h
GROUP BY CAR_ID
HAVING AVAILABLE = 1) as p
JOIN CAR_RENTAL_COMPANY_CAR c on p.CAR_ID = c.CAR_ID
WHERE CAR_TYPE = "세단" or CAR_TYPE = "SUV") as f JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN d ON f.CAR_TYPE = d.CAR_TYPE AND d.DURATION_TYPE = "30일 이상"
HAVING FEE BETWEEN 500000 and 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC