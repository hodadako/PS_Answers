n = int(input())
steps = []
for i in range(n):
    steps.append(int(input()))

if n == 1 or n == 2:
    print(sum(steps))
elif n == 3: 
    print(steps[2] + max(steps[1], steps[0]))
else: 
    dp = [0] * n
    dp[0] = steps[0]
    dp[1] = steps[1] + steps[0]
    dp[2] = steps[2] + max(steps[1], steps[0])
    for i in range(3, n):
        dp[i] = steps[i] + max(dp[i - 3] + steps[i - 1], dp[i - 2])
    print(dp[n - 1])