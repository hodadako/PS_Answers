from itertools import combinations as cb

nums = []

for i in range(9):
    n = int(input())
    nums.append(n)

nums.sort()

a = list(cb(nums, 7))

for i in a:
    if sum(i) == 100:
        for j in range(len(i)):
            print(i[j])
        break