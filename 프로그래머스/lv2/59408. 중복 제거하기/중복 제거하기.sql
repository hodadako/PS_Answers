SELECT COUNT(distinct case when NAME is not null then NAME end)
FROM ANIMAL_INS
