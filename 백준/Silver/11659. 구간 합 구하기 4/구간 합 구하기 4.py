from sys import stdin
input = stdin.readline

n, m = map(int, input().rstrip().split())
nums = [0]
nums += list(map(int, input().rstrip().split()))
for i in range(1, n + 1):
    nums[i] = nums[i - 1] + nums[i]

for _ in range(m):
    a, b = map(int, input().rstrip().split())
    print(nums[b] - nums[a - 1])