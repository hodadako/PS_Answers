from sys import stdin
from copy import deepcopy
input = stdin.readline

n, m = map(int, input().rstrip().split())
nums = list(map(int, input().rstrip().split()))
sums = deepcopy(nums)
for i in range(1, n):
    sums[i] = sums[i - 1] + sums[i]

if m == n:
    answer = sum(nums)
else:
    answer = sums[m - 1]
    for i in range(m, n):
        answer = max(answer, sums[i] - sums[i - m])

print(answer)