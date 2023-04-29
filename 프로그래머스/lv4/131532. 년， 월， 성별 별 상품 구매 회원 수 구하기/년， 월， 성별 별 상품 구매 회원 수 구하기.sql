-- 코드를 입력하세요
SELECT YEAR(o.SALES_DATE) as YEAR, MONTH(o.SALES_DATE) as MONTH, u.GENDER, COUNT(DISTINCT o.USER_ID) as USERS
FROM ONLINE_SALE o INNER JOIN USER_INFO u ON o.USER_ID = u.USER_ID
WHERE u.GENDER IS NOT NULL
GROUP BY MONTH(o.SALES_DATE), u.GENDER
ORDER BY YEAR, MONTH, GENDER