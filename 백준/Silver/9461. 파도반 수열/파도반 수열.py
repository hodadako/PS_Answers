t = int(input())
dp = [0] * 101


key = [1, 1, 1, 2, 2, 3, 4, 5, 7, 9]
for i in range(1, 11):
    dp[i] = key[i - 1]

for i in range(11, 101):
    dp[i] = dp[i - 1] + dp[i - 5]

nums = []
for _ in range(t):
    nums.append(int(input()))

for i in range(t):
    print(dp[nums[i]])