SELECT SUBSTRING(PRODUCT_CODE, 1, 2) as CATEGORY, COUNT(PRODUCT_ID) as PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY
ORDER BY CATEGORY  