n = int(input())
dp = [0] * (50177)
for i in range(1, 224):
    dp[i ** 2] = 1

for i in range(1, 224):
    for j in range(i ** 2 + 1, (i + 1) ** 2):
        dp[j] = dp[j - i ** 2] + dp[i ** 2]
        for k in range(1, i + 1):
            dp[j] = min(dp[j], dp[(i - k) ** 2] + dp[j - (i - k)**2])
            

print(dp[n])